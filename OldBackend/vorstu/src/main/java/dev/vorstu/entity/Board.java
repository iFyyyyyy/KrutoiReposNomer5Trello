package dev.vorstu.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    private boolean IsPublic;
}
