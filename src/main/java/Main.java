import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import skillbox.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        int changedRows = session.createQuery(Queries.fillLinkedPurchaseList).executeUpdate();

        System.out.println(changedRows);

        transaction.commit();

        LinkedPurchaseList.LinkedPurchaseListId id = new LinkedPurchaseList.LinkedPurchaseListId(1,2);

        LinkedPurchaseList list = session.get(LinkedPurchaseList.class, id);

        System.out.println(list.getStudent().getName() + " " + list.getCourse().getName());
//
//        System.out.println("Подписка имя и id курса: " + list.getCourseName() + ", " + list.getCourseId() +
//                ", имя и id студента: " + list.getStudentName()+ ", " + list.getStudentId());
//
//        List<Student> students = list.getCourse().getStudents();
//
//        System.out.println("студенты  которые подписаны на курс " + list.getCourseName() + " с id " + list.getCourseId());
//
//        students.stream().map(c -> c.getName()).forEach(System.out::println);
//
//        List<Course> courses = list.getStudent().getCourses();
//
//        System.out.println("курсы на которые подписан студент " + list.getStudentName() + " с id " + list.getStudentId());
//
//        courses.stream().map(s -> s.getName()).forEach(System.out::println);
//


//        System.out.println("Test Course");
//
//        Course course = session.get(Course.class, 3);
//
//        System.out.println(course.getTeacher().getName() + " " + course.getName() + " " + course.getDescription() + " " + course.getType());
//
//        System.out.println("через Student");
//
//        course.getStudents().forEach(s -> System.out.println(s.getName() + " " + s.getAge()));
//
//        System.out.println("через Subscription");
//
//        course.getSubscriptions().forEach(s-> System.out.println(s.getStudent().getName() + " " + s.getCourse().getName()  + " " + s.getSubscriptionDate()));
//
//        System.out.println("Test Student");
//
//        Student student = session.get(Student.class, 6);
//
//        System.out.println("через Course");
//
//        student.getCourses().forEach(s -> System.out.println(s.getName() + " " + s.getDescription() + " " + s.getTeacher().getName()));
//
//        System.out.println(student.getName() + " " + student.getAge() + " " + student.getId());
//
//        System.out.println("через Subscription");
//
//        student.getSubscriptions().forEach(s-> System.out.println(s.getStudent().getName() + " " + s.getCourse().getName()  + " " + s.getSubscriptionDate()));
//
//        System.out.println("Test Teacher");
//
//        Teacher teacher = session.get(Teacher.class, 10);
//
//        System.out.println(teacher.getName() + " " + teacher.getAge() + " " + teacher.getId() + " " + teacher.getSalary());
//
//        teacher.getCourses().forEach(c -> System.out.println(c.getName()));
//
        System.out.println("Test Subscription");

        Subscription.SubscriptionId subscriptionId = new Subscription.SubscriptionId (2, 11);

        Subscription subscription =  session.get(Subscription.class, subscriptionId);

        System.out.println(subscription.getCourse().getName() + " " + subscription.getStudent().getName() + " " + subscription.getSubscriptionDate());

        System.out.println("Test PurchaseList");

        PurchaseList.PurchaseListId purchaseListId = new PurchaseList.PurchaseListId("Квасников Емельян", "Рекламная графика");
        PurchaseList purchaseList = session.get(PurchaseList.class, purchaseListId);

        System.out.println(purchaseList.getCourseName() + " " +  purchaseList.getPrice()  + " " +  purchaseList.getSubscriptionDate());
        sessionFactory.close();

    }
}
