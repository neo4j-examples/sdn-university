/*
 * Copyright [2011-2016] "Neo Technology"
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 *
 */
package school.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import school.domain.StudyBuddy;
import school.repository.StudyBuddyRepository;


@RestController
@RequestMapping(value = "/api/studyBuddies", consumes = MediaType.APPLICATION_JSON_VALUE)
public class StudyBuddyController {

	private StudyBuddyRepository studyBuddyRepository;

	@Autowired
	public StudyBuddyController(StudyBuddyRepository studyBuddyRepository) {
		this.studyBuddyRepository = studyBuddyRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<StudyBuddy> readAll() {
		return studyBuddyRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public StudyBuddy create(@RequestBody StudyBuddy studyBuddy) {
		return studyBuddyRepository.save(studyBuddy);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public StudyBuddy read(@PathVariable Long id) {
		return studyBuddyRepository.findOne(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		studyBuddyRepository.delete(id);
	}

	@Transactional
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public StudyBuddy update(@PathVariable Long id, @RequestBody StudyBuddy update) {
		final StudyBuddy existing = studyBuddyRepository.findOne(id);
		existing.updateFrom(update);
		return studyBuddyRepository.save(existing);
	}

	@Transactional(readOnly = true)
	@RequestMapping("/popular")
	public Iterable<Map<String, Object>> popularStudyBuddies() {
		return studyBuddyRepository.getStudyBuddiesByPopularity();
	}
}
