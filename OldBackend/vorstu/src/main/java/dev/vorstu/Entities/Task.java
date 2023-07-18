package dev.vorstu.Entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String taskName;

    private String taskDescription;

    //@JsonBackReference
    @ManyToOne(fetch =  FetchType.LAZY)
    private Column column;


    private Long taskPosition;

    private Date lastUpdated;


//    public Date getSubmissionDateConverted(String timezone) throws ParseException {
//        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
//        return dateFormat.parse(this.date);
//    }
//
//    public void setSubmissionDate(Date date, String timezone) {
//        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
//        this.date = dateFormat.format(date);
//    }


    // Files
}
