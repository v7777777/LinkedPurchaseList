package skillbox;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
@EqualsAndHashCode
@Embeddable
public class SubscriptionId implements Serializable {

    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "course_id")
    private Integer courseId;

    private SubscriptionId() { }

    public SubscriptionId(Integer studentId, Integer courseId) {
        this.studentId = studentId;
        this.courseId = courseId;

    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }




}


