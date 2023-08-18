package dev.vorstu.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @SequenceGenerator(name = "user_seq", sequenceName = "user_sequence",
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @javax.persistence.Column(name = "id", nullable = false)
    private Long id;

    private String username;

    @Enumerated(EnumType.STRING)
    private Role role;

    //static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "password_id", nullable = false)
    private Password password;

//    public String SetPassword(String password) {
//        return this.password = passwordEncoder.encode(password);
//    }

    @OneToMany( cascade = CascadeType.ALL, mappedBy = "user")
    private List<Board> Board;

    private boolean enable;

    @Enumerated(EnumType.STRING)
    private Theme theme;
}
