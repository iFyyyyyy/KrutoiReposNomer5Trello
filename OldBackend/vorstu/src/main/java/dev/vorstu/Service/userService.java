package dev.vorstu.Service;

import dev.vorstu.entity.Student;
import dev.vorstu.entity.User;
import dev.vorstu.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service


public class userService {
    @Autowired
    private UserRepository userRepository;

    public User findByUsername(String username) {

        User user = userRepository.findUserByUsername(username).orElseThrow(() -> new RuntimeException("Не найден пользователь: " + username)); // bez get oshibka
        if (user == null){
            log.info("Cant find user by username");
        }
        return user;
    }


}
