package face_bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Service;

import face_bank.domain.StudyBuddy;
import face_bank.repository.StudyBuddyRepository;

import java.util.Map;

@Service("studyBuddyService")
public class StudyBuddyServiceImpl extends GenericService<StudyBuddy> implements StudyBuddyService {

    @Autowired
    private StudyBuddyRepository repository;

    @Override
    public GraphRepository<StudyBuddy> getRepository() {
        return repository;
    }

    @Override
    public Iterable<Map<String,Object>> getStudyBuddiesByPopularity() {
        return repository.getStudyBuddiesByPopularity();
    }
}
