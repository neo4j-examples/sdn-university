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

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import school.domain.Student;
import school.domain.Teacher;
import school.domain.TeacherAndStudentRelationship;
import school.service.Service;
import school.service.StudentService;
import school.service.TeacherAndStudentRelationshipService;
import school.service.TeacherService;

@RestController
@RequestMapping(value = "/api/teachers")
public class TeacherController extends Controller<Teacher> {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherAndStudentRelationshipService teacherAndStudentRelationshipService;

    @Override
    public Service<Teacher> getService() {
        return teacherService;
    }

    @RequestMapping(value = "/relate/{teacherId}/{studentId}", method = RequestMethod.GET)
    public String relate(@PathVariable Long teacherId, @PathVariable Long studentId, final HttpServletResponse response) {

        Teacher teacher = teacherService.find(teacherId);
        Student student = studentService.find(studentId);

        TeacherAndStudentRelationship teacherAndStudentRelationship = new TeacherAndStudentRelationship();
        teacherAndStudentRelationship.setTeacher(teacher);
        teacherAndStudentRelationship.setStudent(student);
        teacherAndStudentRelationshipService.createOrUpdate(teacherAndStudentRelationship);

        String message = "Teacher #" + teacher.getId() + " should now be related to Student #" + student.getId();
        System.out.println(message);

        return message;

    }

}