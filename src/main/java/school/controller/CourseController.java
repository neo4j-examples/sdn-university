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
import school.domain.Course;
import school.repository.CourseRepository;

@RestController
@RequestMapping(value = "/api/classes")
public class CourseController {

	private CourseRepository courseRepository;

	@Autowired
	public CourseController(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Course> readAll() {
		return courseRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Course create(@RequestBody Course course) {
		return courseRepository.save(course);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Course read(@PathVariable Long id) {
		return courseRepository.findById(id).orElseThrow(NotFoundException::new);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		courseRepository.deleteById(id);
	}

	@Transactional
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Course update(@PathVariable Long id, @RequestBody Course update) {
		final Course existing = courseRepository.findById(id).orElseThrow(NotFoundException::new);
		existing.updateFrom(update);
		return courseRepository.save(existing);
	}
}
