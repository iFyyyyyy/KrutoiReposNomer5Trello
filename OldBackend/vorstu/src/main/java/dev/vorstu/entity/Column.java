package dev.vorstu.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "columns")
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
    @JoinColumn(name="board_id", nullable=false)
    private Board board;

    private Long columnPosition;
}
