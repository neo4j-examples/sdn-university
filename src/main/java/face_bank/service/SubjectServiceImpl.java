package face_bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Service;

import face_bank.domain.Subject;
import face_bank.repository.SubjectRepository;

@Service("subjectService")
public class SubjectServiceImpl extends GenericService<Subject> implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public GraphRepository<Subject> getRepository() {
        return subjectRepository;
    }
}
