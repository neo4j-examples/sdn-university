package face_bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import face_bank.domain.Teacher;
import face_bank.service.Service;
import face_bank.service.TeacherService;

@RestController
@RequestMapping(value = "/api/teachers")
public class TeacherController extends Controller<Teacher> {

    @Autowired
    private TeacherService teacherService;

    @Override
    public Service<Teacher> getService() {
        return teacherService;
    }

}