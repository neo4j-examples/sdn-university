package school.domain;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type = "TEACHER_AND_STUDENT_RELATIONSHIP")
public class TeacherAndStudentRelationship extends Entity {

    @StartNode
    private Student student;

    @EndNode
    private Teacher teacher;

    public TeacherAndStudentRelationship() {
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + getId() +
                ", teacher='" + teacher.getId() + '\'' +
                ", student='" + student.getId() + '\'' +
                '}';
    }
}