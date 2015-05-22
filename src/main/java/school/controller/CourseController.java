package school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import school.domain.Course;
import school.service.ClassRegisterService;
import school.service.Service;

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