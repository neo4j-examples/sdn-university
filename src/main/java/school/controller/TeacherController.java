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
import school.domain.Teacher;
import school.repository.TeacherRepository;

@RestController
@RequestMapping(value = "/api/teachers")
public class TeacherController {

	private TeacherRepository teacherRepository;

	@Autowired
	public TeacherController(TeacherRepository teacherRepository) {
		this.teacherRepository = teacherRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Teacher> readAll() {
		return teacherRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Teacher create(@RequestBody Teacher teacher) {
		return teacherRepository.save(teacher);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Teacher read(@PathVariable Long id) {
		return teacherRepository.findById(id).orElseThrow(NotFoundException::new);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		teacherRepository.deleteById(id);
	}

	@Transactional
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Teacher update(@PathVariable Long id, @RequestBody Teacher update) {
		final Teacher existing = teacherRepository.findById(id).orElseThrow(NotFoundException::new);
		existing.updateFrom(update);
		return teacherRepository.save(existing);
	}
}
