package school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import school.domain.Subject;
import school.service.Service;
import school.service.SubjectService;

@RestController
@RequestMapping(value = "/api/subjects")
public class SubjectController extends Controller<Subject> {

    @Autowired
    private SubjectService subjectService;

    @Override
    public Service<Subject> getService() {
        return subjectService;
    }

}