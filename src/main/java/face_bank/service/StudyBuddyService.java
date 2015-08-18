package face_bank.service;

import java.util.Map;

import face_bank.domain.StudyBuddy;

public interface StudyBuddyService extends Service<StudyBuddy> {

    Iterable<Map<String,Object>> getStudyBuddiesByPopularity();

}
