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
import school.domain.Department;
import school.repository.DepartmentRepository;

@RestController
@RequestMapping(value = "/api/departments")
public class DepartmentController {

	private DepartmentRepository departmentRepository;

	@Autowired
	public DepartmentController(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Department> readAll() {
		return departmentRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Department create(@RequestBody Department department) {
		return departmentRepository.save(department);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Department read(@PathVariable Long id) {
		return departmentRepository.findOne(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		departmentRepository.delete(id);
	}

	@Transactional
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Department update(@PathVariable Long id, @RequestBody Department update) {
		final Department existing = departmentRepository.findOne(id);
		existing.updateFrom(update);
		return departmentRepository.save(existing);
	}
}
