package face_bank.service;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import face_bank.domain.Student;
import face_bank.repository.StudentRepository;

@Service("studentService")
public class StudentServiceImpl extends GenericService<Student> implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public GraphRepository<Student> getRepository() {
        return studentRepository;
    }
}
