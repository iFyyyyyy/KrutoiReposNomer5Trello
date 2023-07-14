package dev.vorstu.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "task")
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String tasKName;

    private String taskDescription;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="column_id", nullable=false)
    private Column column;

    @javax.persistence.Column(unique=true)
    private Long taskPosition;

    private Date lastUpdated;


    // Files
}
