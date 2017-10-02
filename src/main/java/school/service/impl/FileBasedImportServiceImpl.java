package school.service.impl;

import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import school.service.ImportService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;

/**
 * Created by markangrish on 18/01/2017.
 */
@Service
public class FileBasedImportServiceImpl implements ImportService {

	private Session session;

	@Autowired
	public FileBasedImportServiceImpl(Session session) {
		this.session = session;
	}

	@Transactional
	public void clearDatabase() {
		session.purgeDatabase();
	}

	@Transactional
	public void load() {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream("school.cql")));
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line);
				sb.append(" ");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		String cqlFile = sb.toString();
		session.query(cqlFile, Collections.EMPTY_MAP);
	}
}
