package face_bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import face_bank.domain.School;
import face_bank.service.ImportService;
import face_bank.service.SchoolService;

@RestController
public class ImportController {

    @Autowired
    private SchoolService schoolService;

    @Autowired
    ImportService importService;

    @RequestMapping("/api/reload")
    public Iterable<School> reload() {

        importService.reload();

        return schoolService.findAll();
    }

}