package school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import school.domain.Student;
import school.service.Service;
import school.service.StudentService;

@RestController
@RequestMapping(value = "/api/students")
public class StudentController extends Controller<Student> {

    @Autowired
    private StudentService studentService;

    @Override
    public Service<Student> getService() {
        return studentService;
    }

}