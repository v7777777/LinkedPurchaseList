package skillbox;

public class Queries {

 public static final String fillLinkedPurchaseList = "insert into LinkedPurchaseList (studentName, studentId, courseName, " +
         "courseId, price, subscriptionDate) " +
         "select student.name, " +
         "student.id, course.name, course.id,  course.price, " +
         "subscription.subscriptionDate from Course course inner join Subscription subscription on subscription.subscriptionId.courseId = course.id  " +
         "inner join Student student on student.id = subscription.subscriptionId.studentId";
}
