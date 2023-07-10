package dev.vorstu;

import dev.vorstu.entity.*;

//import dev.vorstu.repositories.GroupRepository;
//import dev.vorstu.repositories.StudentRepository;
////import dev.vorstu.repositories.UserInfoRepository;
import dev.vorstu.repositories.UserRepository;
import jdk.nashorn.internal.runtime.Undefined;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Initializer {


//    @Autowired
//    private StudentRepository studentRepository;
    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    private GroupRepository groupRepository;
    //@Autowired
    //private UserInfoRepository userInfoRepository;



    public void initial() {
        User user = new User();

        userRepository.save(new User(1L,"user1",Role.USER, user.SetPassword("1234"), true));


    }
}
