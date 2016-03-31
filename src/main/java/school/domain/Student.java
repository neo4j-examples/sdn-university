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

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;


@NodeEntity
public class Student extends Entity {

    private String name;

    @Relationship(type = "ENROLLED")
    private Set<Course> courses;

    @Relationship(type="BUDDY", direction=Relationship.INCOMING)
    private Set<StudyBuddy> studyBuddies;

    public Student() {
        this.studyBuddies = new HashSet<>();
        this.courses = new HashSet<>();
    }

    public Student(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<StudyBuddy> getStudyBuddies() {
        return studyBuddies;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses( Set<Course> courses ) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", courses=" + courses.size() +
                ", studyBuddies=" + studyBuddies.size() +
                '}';
    }
}
