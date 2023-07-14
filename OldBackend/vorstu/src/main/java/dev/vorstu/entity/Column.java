package dev.vorstu.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "column")
@Table(name = "columns")
//@NamedQuery(query = "Select e from columns c where c.board_id = :id", name = "find column by boardId")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Column {


    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String columnName;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="board_id", nullable=false)
    private Board board;

    @JsonManagedReference
    @OneToMany(mappedBy = "column")
    private List<Task> tasks;

    @javax.persistence.Column(unique=true)
    private Long columnPosition;
}
