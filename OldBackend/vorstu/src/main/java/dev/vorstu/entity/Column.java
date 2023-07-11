package dev.vorstu.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
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



    private Long columnPosition;
}
