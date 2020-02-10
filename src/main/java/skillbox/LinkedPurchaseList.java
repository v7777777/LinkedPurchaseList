package skillbox;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "LinkedPurchaseList")
@IdClass(LinkedPurchaseList.LinkedPurchaseListId.class)
public class LinkedPurchaseList implements Serializable {

    @Id
    @Column(name = "student_id", columnDefinition = "int(10) unsigned", nullable = false)
    Integer studentId;

    @Id
    @Column(name = "course_id", columnDefinition = "int(10) unsigned", nullable = false)
    Integer courseId;

    @Column(name = "price", columnDefinition = "int(10) unsigned", nullable = false)
    Integer  price;

    @ManyToOne
    @MapsId("courseId")
    private Course course;

    @ManyToOne
    @MapsId("studentId")
    private Student student;

    @Column(name = "date", columnDefinition = "datetime", nullable = false)
    private LocalDateTime subscriptionDate;

    private  LinkedPurchaseList () {}

    public LinkedPurchaseList(Student student, Course course) {
        this.student = student;
        this.course = course;

    }

    @EqualsAndHashCode
    @Embeddable
    public static class LinkedPurchaseListId implements Serializable {

        @Getter
        @Setter
        Integer studentId;
        @Getter
        @Setter
        Integer courseId;

        public LinkedPurchaseListId(Integer studentId, Integer courseId) {
            this.studentId = studentId;
            this.courseId = courseId;
        }

        public LinkedPurchaseListId() { }



    }

    public int getCourseId() {
        return course.getId();
    }

    public void setCourseId(int id) {
        course.setId(id);
    }

    public int getStudentId() {
        return student.getId();
    }

    public void setStudentId(int id) {
        student.setId(id);
    }

    public int getCoursePrice() {
        return course.getPrice();
    }

    public void setCoursePrice(int price) {
        course.setPrice(price);
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




}
