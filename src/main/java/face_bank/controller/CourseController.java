package face_bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import face_bank.domain.Course;
import face_bank.service.ClassRegisterService;
import face_bank.service.Service;

@RestController
@RequestMapping(value = "/api/classes")
public class CourseController extends Controller<Course> {

    @Autowired
    private ClassRegisterService classRegisterService;

    @Override
    public Service<Course> getService() {
        return classRegisterService;
    }

}