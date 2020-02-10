package skillbox;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "PurchaseList")
public class PurchaseList {

  @EmbeddedId
  private PurchaseListId purchaseListId;

  @Column(name = "student_name", insertable=false, updatable=false)
  private String studentName;

  @Column(name = "course_name", insertable=false, updatable=false)
  private String courseName;

  private int price;

  @Column(name = "subscription_date")
  private LocalDateTime subscriptionDate;

  public PurchaseList(String studentName, String courseName) {
    this.studentName = studentName;
    this.courseName = courseName;
    this.purchaseListId = new PurchaseListId(studentName, courseName);

  }

  public PurchaseList() { }


  public PurchaseListId getPurchaseListId() {
    return purchaseListId;
  }

  public void setPurchaseListId(PurchaseListId purchaseListId) {
    this.purchaseListId = purchaseListId;
  }

  @EqualsAndHashCode
  @Embeddable
  public static class PurchaseListId implements Serializable {

    @Getter
    @Setter
    @Column(name = "student_name")
    private String studentName;

    @Getter
    @Setter
    @Column(name = "course_name")
    private String courseName;

    private PurchaseListId() { }

    public PurchaseListId(String studentName, String courseName) {
      this.studentName = studentName;
      this.courseName = courseName;
    }


  }


  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public LocalDateTime getSubscriptionDate() {
    return subscriptionDate;
  }

  public void setSubscriptionDate(LocalDateTime subscriptionDate) {
    this.subscriptionDate = subscriptionDate;
  }






}

