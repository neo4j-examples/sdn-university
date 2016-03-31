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
public class School extends Entity {

    private String name;

    @Relationship(type = "DEPARTMENT")
    private Set<Department> departments;

    @Relationship(type = "STAFF")
    private Set<Teacher> teachers;

    @Relationship(type = "HEAD_TEACHER")
    private Teacher headTeacher;

    @Relationship(type = "STUDENT")
    private Set<Student> students;

    public School() {
        this.departments = new HashSet<>();
        this.teachers = new HashSet<>();
        this.students = new HashSet<>();
    }

    public School(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    public Teacher getHeadTeacher() {
        return headTeacher;
    }

    public void setHeadTeacher(Teacher headTeacher) {
        this.headTeacher = headTeacher;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", departments=" + departments.size() +
                ", teachers=" + teachers.size() +
                ", students=" + students.size() +
                '}';
    }
}

