package dev.vorstu.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

//    public User (String username, Password password, Role role, Student student, boolean enable){
//        this.username = username;
//        this.password = password;
//        this.role = role;
//        this.student = student;
//        this.enable = enable;
//    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    // @Enumerated - позволяет управлять типом поля, которое сохраняется в бд.
    // По умолчанию сохраняется цифра, так как енам это константный список.
    @Enumerated(EnumType.STRING)
    private Role role;



    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "password_id", nullable = false)
    private Password password;


//    @OneToOne(cascade = CascadeType.MERGE)
//    @JoinColumn(name = "student_id", referencedColumnName = "id")
//    private Student student;

    private boolean enable;
}
