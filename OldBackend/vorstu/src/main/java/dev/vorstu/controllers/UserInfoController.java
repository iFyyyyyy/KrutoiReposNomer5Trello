//package dev.vorstu.controllers;
//
//import dev.vorstu.Mappers.StudentDataMapper;
//import dev.vorstu.entity.Student;
//import dev.vorstu.entity.StudentDTO;
//import dev.vorstu.entity.User;
//import dev.vorstu.repositories.UserRepository;
//import dev.vorstu.Service.userService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.security.Principal;
//import java.util.function.Function;
//
//@RestController
//@RequestMapping(value = "/api/students", produces = MediaType.APPLICATION_JSON_VALUE)
//@Slf4j // log.info
//
//public class UserInfoController {
//
//    @Autowired
//    private userService userService;
//
//    @PostMapping(value = "/userInfo")
//    public StudentDTO getUserInfo(Principal user){
//        UsernamePasswordAuthenticationToken token = ((UsernamePasswordAuthenticationToken) user);
//        User currentUser = userService.findByUsername(token.getName());
//        log.info("Sending {} info", token.getName());
//        Student student = currentUser.getStudent();
//        return studentToStudentDTO(student);
//
//    }
//
//    public StudentDTO studentToStudentDTO(Student student){
//        StudentDTO studentDTO = StudentDataMapper.INSTANCE.StudentToStudentDTO(student);
//        return studentDTO;
//        }
//
//
//        //curl -X POST "http://localhost:8080/api/userInfo" -H "Authorization: Basic dXNlcjE6MTIzNA==" -H "Content-Type:application/json" -v
//
//}
