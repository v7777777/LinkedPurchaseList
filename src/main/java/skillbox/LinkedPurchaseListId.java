package skillbox;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@EqualsAndHashCode
@Embeddable

public class LinkedPurchaseListId implements Serializable {

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
