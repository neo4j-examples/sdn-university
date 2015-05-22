package school.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import school.domain.StudyBuddy;
import school.service.Service;
import school.service.StudyBuddyService;

@RestController
@RequestMapping(value = "/api/studyBuddies")
public class StudyBuddyController extends Controller<StudyBuddy> {

    @Autowired
    private StudyBuddyService studyBuddyService;

    @Override
    public Service<StudyBuddy> getService() {
        return studyBuddyService;
    }

    @RequestMapping("/popular")
    public Iterable<Map<String, Object>> popularStudyBuddies() {
        return studyBuddyService.getStudyBuddiesByPopularity();
    }

}