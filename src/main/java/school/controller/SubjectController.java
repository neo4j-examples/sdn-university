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

import org.neo4j.ogm.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import school.domain.Subject;
import school.repository.SubjectRepository;

@RestController
@RequestMapping(value = "/api/subjects")
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
		return subjectRepository.findById(id).orElseThrow(NotFoundException::new);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		subjectRepository.deleteById(id);
	}

	@Transactional
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Subject update(@PathVariable Long id, @RequestBody Subject update) {
		final Subject existing = subjectRepository.findById(id).orElseThrow(NotFoundException::new);
		existing.updateFrom(update);
		return subjectRepository.save(existing);
	}
}
