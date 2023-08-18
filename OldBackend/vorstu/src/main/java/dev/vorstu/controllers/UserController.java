package dev.vorstu.controllers;

import dev.vorstu.dto.ColumnDTO;
import dev.vorstu.entities.Theme;
import dev.vorstu.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/theme", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j // log.info
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getTheme/")
    public Theme getTheme() {
        return userService.getTheme();
    }

    @GetMapping("/changeTheme/")
    public Theme changeTheme() {
        return userService.changeTheme();
    }
}
