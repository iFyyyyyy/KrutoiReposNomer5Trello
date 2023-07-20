package dev.vorstu.entities;

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
    @SequenceGenerator(name = "board_seq", sequenceName = "board_sequence",
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_seq")
    @javax.persistence.Column(name = "id", nullable = false)
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
