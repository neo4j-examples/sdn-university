package school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import school.domain.Teacher;
import school.service.Service;
import school.service.TeacherService;

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