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

import java.util.ArrayList;
import java.util.List;

@JsonIdentityInfo(generator = JSOGGenerator.class)
@NodeEntity
public class StudyBuddy {

	private Long id;

	@Relationship(type = "BUDDY")
	private List<Student> buddies;

	private Course course;

	public StudyBuddy() {
		buddies = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public Course getCourse() {
		return course;
	}

	@Override
	public String toString() {
		return "StudyBuddy{" +
				"buddies= " + buddies.size() +
				", course=" + course +
				'}';
	}

	public void updateFrom(StudyBuddy studyBuddy) {
		this.course = studyBuddy.course;
	}
}
