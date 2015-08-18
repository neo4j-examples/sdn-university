package face_bank.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import face_bank.domain.Course;

public interface CourseRepository extends GraphRepository<Course> {

}

