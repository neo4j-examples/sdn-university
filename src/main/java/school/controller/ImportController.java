package school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import school.domain.School;
import school.service.ImportService;
import school.service.SchoolService;

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