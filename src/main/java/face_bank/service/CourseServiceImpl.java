package face_bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Service;

import face_bank.domain.Course;
import face_bank.repository.CourseRepository;

@Service("courseService")
public class CourseServiceImpl extends GenericService<Course> implements ClassRegisterService {

    @Autowired
    private CourseRepository repository;

    @Override
    public GraphRepository<Course> getRepository() {
        return repository;
    }
}
