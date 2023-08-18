package dev.vorstu.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;


@Entity
@Table(name = "passwords")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Password {

    static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Password(String password) {
        this.password = passwordEncoder.encode(password);
    }

    @Id
    @SequenceGenerator(name = "password_seq", sequenceName = "password_sequence",
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "password_seq")
    @javax.persistence.Column(name = "id", nullable = false)
    private Long id;

    private String password;

    private void setPasswordWithEncoding(String password) {
        this.password = passwordEncoder.encode(password);
    }


}
