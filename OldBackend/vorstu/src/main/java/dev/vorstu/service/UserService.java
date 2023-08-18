package dev.vorstu.service;

import dev.vorstu.entities.Theme;
import dev.vorstu.entities.User;
import dev.vorstu.mappers.UserDataMapper;
import dev.vorstu.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j // log.info
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDataMapper userDataMapper;

    public Enum<Theme> getTheme(Long userId) {
        return userRepository.findById(userId).get().getTheme();
    }

    public Object getUserDetails(String username) {
        return userDataMapper.UserToUserDTO(userRepository.getUser(username));
    }

    public String changeTheme(Long userId, String theme) {
        User user = this.userRepository.findById(userId).get();
            if(theme == "DARK") {
                user.setTheme(Theme.LIGHT);
            }
            else {
                user.setTheme(Theme.DARK);
            }
        userRepository.save(user);
        return theme;
    }

}
