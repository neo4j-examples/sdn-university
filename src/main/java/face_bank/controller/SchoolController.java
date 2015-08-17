package face_bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import face_bank.domain.School;
import face_bank.service.SchoolService;
import face_bank.service.Service;

@RestController
@RequestMapping(value = "/api/schools")
public class SchoolController extends Controller<School> {

    @Autowired
    private SchoolService schoolService;

    @Override
    public Service<School> getService() {
        return schoolService;
    }

}