import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Subscriptions")
public class Subscription implements Serializable {
    @EmbeddedId
    private Id id;
    @Column(name = "subscription_date")
    private Date date;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

/** СОЗДАЁМ КЛАСС СОСТАВНОГО КЛЮЧА */
    @Embeddable
    public class Id implements Serializable {
        public Id() {
        }
/*    private Long id;*/

        @Column(name = "student_id")
        private Integer studentId;

        @Column(name = "course_id")
        private Integer courseId;

        public Id(Integer studentId, Integer courseId) {
            this.setStudentId(studentId);
            this.setCourseId(courseId);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Id)) return false;
            Id that = (Id) o;
            return Objects.equals(getCourseId(), that.getCourseId()) &&
                    Objects.equals(getStudentId(), that.getStudentId());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getCourseId(), getStudentId());
        }

        public Integer getStudentId() {
            return studentId;
        }

        public void setStudentId(Integer studentId) {
            this.studentId = studentId;
        }

        public Integer getCourseId() {
            return courseId;
        }

        public void setCourseId(Integer courseId) {
            this.courseId = courseId;
        }
    }
}