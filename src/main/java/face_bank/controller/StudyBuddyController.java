package face_bank.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import face_bank.domain.StudyBuddy;
import face_bank.service.Service;
import face_bank.service.StudyBuddyService;

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