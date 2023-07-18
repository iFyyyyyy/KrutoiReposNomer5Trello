package dev.vorstu.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "boards")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Board {


    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String boardName;

    private String boardDescription;

    private Long boardPosition;

    @ManyToOne(fetch =  FetchType.LAZY)
    private User user;

    @OneToMany( cascade = CascadeType.ALL, mappedBy = "board")
    private List<Column> Columns;


    private boolean IsPublic;
}
