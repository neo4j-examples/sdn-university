package school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Service;

import school.domain.TeacherAndStudentRelationship;
import school.repository.TeacherAndStudentRelationshipRepository;

@Service("teacherAndStudentRelationshipService")
public class TeacherAndStudentRelationshipServiceImpl extends GenericService<TeacherAndStudentRelationship> implements TeacherAndStudentRelationshipService {

    @Autowired()
    private TeacherAndStudentRelationshipRepository teacherAndStudentRelationshipRepository;

    @Override
    public GraphRepository<TeacherAndStudentRelationship> getRepository() {
        return teacherAndStudentRelationshipRepository;
    }
}
