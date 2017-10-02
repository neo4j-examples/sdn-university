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
package school.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@JsonIdentityInfo(generator = JSOGGenerator.class)
@NodeEntity
public class Department {

	private Long id;

	private String name;

	@Relationship(type = "DEPARTMENT_MEMBER")
	private Set<Teacher> teachers;

	@Relationship(type = "CURRICULUM")
	private Set<Subject> subjects;

	public Department() {
		this.teachers = new HashSet<>();
		this.subjects = new HashSet<>();
	}

	public Department(String name) {
		this();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	@Override
	public String toString() {
		return "Department{" +
				"id=" + getId() +
				", name='" + name + '\'' +
				", teachers=" + teachers.size() +
				", subjects=" + subjects.size() +
				'}';
	}

	public void updateFrom(Department department) {
		this.name = department.name;
	}
}
