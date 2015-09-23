package school.repository;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import school.domain.TeacherAndStudentRelationship;

@Repository
public interface TeacherAndStudentRelationshipRepository extends GraphRepository<TeacherAndStudentRelationship> {

}
