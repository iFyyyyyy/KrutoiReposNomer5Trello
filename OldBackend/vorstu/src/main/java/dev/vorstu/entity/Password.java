package dev.vorstu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;


@Getter @Setter
@NoArgsConstructor
public class Password {

    static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    private String password;

    public Password(String password) {
        this.password = passwordEncoder.encode(password);}



}
