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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import school.domain.Subject;
import school.repository.SubjectRepository;

@RestController
@RequestMapping(value = "/api/subjects", consumes = MediaType.APPLICATION_JSON_VALUE)
public class SubjectController {

	private SubjectRepository subjectRepository;

	@Autowired
	public SubjectController(SubjectRepository subjectRepository) {
		this.subjectRepository = subjectRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Subject> readAll() {
		return subjectRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Subject create(@RequestBody Subject subject) {
		return subjectRepository.save(subject);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Subject read(@PathVariable Long id) {
		return subjectRepository.findOne(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		subjectRepository.delete(id);
	}

	@Transactional
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Subject update(@PathVariable Long id, @RequestBody Subject update) {
		final Subject existing = subjectRepository.findOne(id);
		existing.updateFrom(update);
		return subjectRepository.save(existing);
	}
}
