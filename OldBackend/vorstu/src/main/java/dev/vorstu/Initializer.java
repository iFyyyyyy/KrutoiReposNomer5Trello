package dev.vorstu;

import dev.vorstu.entity.*;

import dev.vorstu.repositories.GroupRepository;
import dev.vorstu.repositories.StudentRepository;
//import dev.vorstu.repositories.UserInfoRepository;
import dev.vorstu.repositories.UserRepository;
import jdk.nashorn.internal.runtime.Undefined;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Initializer {


    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GroupRepository groupRepository;
    //@Autowired
    //private UserInfoRepository userInfoRepository;



    public void initial() {
        groupRepository.save(new Group(
                1L,
                "GroupName1",
                "GroupDescription1",
                "GroupFaculty1",
                null,
                null


        ));

//        studentRepository.save(new Student(
//                "Student1",
//                "VM",
//                "+701"
//
//                ));
//
//        userRepository.save(new User(
//           "user1",
//           new Password("1234"),
//           Role.STUDENT,
//           studentRepository.findById(1L).get(),
//           true
//        ));
//
//        userRepository.save(new User(
//                "admin",
//                new Password ("admin"),
//                Role.ADMIN,
//                null,
//                true
//        ));
//
//        userRepository.save(new User(
//                "teacher",
//                new Password ("teacher"),
//                Role.TEACHER,
//                null,
//                true
//        ));


//        studentRepository.save(new Student("Student1","VM","+701" ));
//        studentRepository.save(new Student("Student2","AM","+702"));
//        studentRepository.save(new Student("Student3","AM","+703"));
//        studentRepository.save(new Student("Student4","VM","+704"));
//        studentRepository.save(new Student("Student5","AM","+705"));
//        studentRepository.save(new Student("Student6","AM","+706"));
//        studentRepository.save(new Student("Student7","AM","+707"));
//        studentRepository.save(new Student("Student8","VM","+708"));
//        studentRepository.save(new Student("Student9","AM","+709"));
//        studentRepository.save(new Student("Student10","AM","+7010"));
//        studentRepository.save(new Student("Student11","AM","+7011"));
//        studentRepository.save(new Student("Student12","VM","+7012"));
//        studentRepository.save(new Student("Student13","AM","+7013"));
//        studentRepository.save(new Student("Student14","AM","+7014"));
//        studentRepository.save(new Student("Student15","AM","+7015"));
//        studentRepository.save(new Student("Student16","VM","+7016"));
//        studentRepository.save(new Student("Student17","AM","+7017"));
//        studentRepository.save(new Student("Student18","AM","+7018"));
//        studentRepository.save(new Student("Student19","AM","+7019"));
//        studentRepository.save(new Student("Student20","VM","+7020"));


    }
}
