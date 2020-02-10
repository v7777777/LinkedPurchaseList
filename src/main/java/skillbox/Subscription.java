package skillbox;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "Subscriptions")
public class Subscription implements Serializable  {

    @EmbeddedId
    private SubscriptionId subscriptionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("courseId")
    private Course course;


    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("studentId")
    private Student student;

    @Column(name = "subscription_date")
    private LocalDateTime subscriptionDate;

    private  Subscription () {}

    public Subscription(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.subscriptionId = new Subscription.SubscriptionId(student.getId(), course.getId());

    }

    @EqualsAndHashCode
    @Embeddable
    public static class SubscriptionId implements Serializable {

        @Getter
        @Setter
        @Column(name = "student_id")
        private Integer studentId;

        @Getter
        @Setter
        @Column(name = "course_id")
        private Integer courseId;

        private SubscriptionId() { }

        public SubscriptionId(Integer studentId, Integer courseId) {
            this.studentId = studentId;
            this.courseId = courseId;

        }

    }

    public LocalDateTime getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(LocalDateTime subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public SubscriptionId getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(SubscriptionId subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

}
