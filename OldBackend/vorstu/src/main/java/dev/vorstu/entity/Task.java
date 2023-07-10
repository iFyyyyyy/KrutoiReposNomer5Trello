package dev.vorstu.entity;


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

    private String tasKName;

    private String taskDescription;

    @ManyToOne
    @JoinColumn(name="column_id", nullable=false)
    private Column column;

    private Long taskPosition;

    private Date lastUpdated;


    // Files
}
