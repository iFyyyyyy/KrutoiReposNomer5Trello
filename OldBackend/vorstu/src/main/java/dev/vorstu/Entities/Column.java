package dev.vorstu.Entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "columns")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Column {


    @Id
    @SequenceGenerator(name = "column_seq", sequenceName = " common_sequence3 ",
            initialValue = 1, allocationSize = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "column_seq")
    @javax.persistence.Column(name = "id", nullable = false)
    private Long id;

    private String columnName;

    private Long columnPosition;

    @ManyToOne(fetch =  FetchType.LAZY)
    private Board board;

    //@JsonManagedReference
    @OneToMany(mappedBy = "column", fetch = FetchType.LAZY) //mappedBy почему так, есть ли разница между joincolumn?
    private List<Task> tasks;


}
