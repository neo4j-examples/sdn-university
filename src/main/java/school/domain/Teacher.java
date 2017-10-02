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
public class Teacher {

	private Long id;

	private String name;

	@Relationship(type = "TEACHES_CLASS")
	private Set<Course> courses;

	@Relationship(type = "DEPARTMENT_MEMBER", direction = Relationship.INCOMING)
	private Department department;

	@Relationship(type = "TAUGHT_BY", direction = Relationship.INCOMING)
	private Set<Subject> subjects;

	public Teacher(String name) {
		this();
		this.name = name;
	}

	public Teacher() {
		this.courses = new HashSet<>();
		this.subjects = new HashSet<>();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public Department getDepartment() {
		return department;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	@Override
	public String toString() {
		return "Teacher{" +
				"id=" + getId() +
				", name='" + name + '\'' +
				", classRegisters=" + courses.size() +
				", department=" + department +
				", subjects=" + subjects.size() +
				'}';
	}

	public void updateFrom(Teacher teacher) {
		this.name = teacher.name;
	}
}
