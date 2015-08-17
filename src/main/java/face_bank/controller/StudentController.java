package face_bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import face_bank.domain.Student;
import face_bank.service.Service;
import face_bank.service.StudentService;

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