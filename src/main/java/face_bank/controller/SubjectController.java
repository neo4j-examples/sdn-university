package face_bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import face_bank.domain.Subject;
import face_bank.service.Service;
import face_bank.service.SubjectService;

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