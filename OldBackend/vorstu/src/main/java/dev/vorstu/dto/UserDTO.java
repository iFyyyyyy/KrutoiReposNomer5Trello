package dev.vorstu.dto;

import dev.vorstu.entities.Board;
import dev.vorstu.entities.Password;
import dev.vorstu.entities.Role;
import dev.vorstu.entities.Theme;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private Role role;
    private boolean enable;
    private Theme theme;
}
