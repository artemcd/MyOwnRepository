import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "Purchaselist")
public class Purchaselist {

    @ManyToOne(cascade = CascadeType.ALL)
    private Students students;
    @ManyToOne(cascade = CascadeType.ALL)
    private Course course;
    private int price;
    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }
}