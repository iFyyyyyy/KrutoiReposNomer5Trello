package dev.vorstu.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CollectionType;
import org.springframework.stereotype.Indexed;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "columns")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Column {


    @Id
    @SequenceGenerator(name = "column_seq", sequenceName = "column_sequence",
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "column_seq")
    @javax.persistence.Column(name = "id", nullable = false)
    private Long id;

    private String columnName;

    private Long columnPosition;

    @ManyToOne(fetch =  FetchType.LAZY)
    private Board board;

    //@JsonManagedReference

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "column", fetch =  FetchType.EAGER) //mappedBy почему так, есть ли разница между joincolumn?
    @OrderBy("taskPosition ASC")
    private List<Task> tasks;


}
