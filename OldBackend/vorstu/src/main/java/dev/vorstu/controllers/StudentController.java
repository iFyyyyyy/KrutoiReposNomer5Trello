package dev.vorstu.controllers;

import dev.vorstu.entity.Student;
import dev.vorstu.Service.studentService;
import dev.vorstu.entity.StudentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {

    @Autowired
    private studentService studentService;

    //@GetMapping("/students")
    //public List<Student> getAllStudents(PageRequest pageRequest) {
    //    return studentService.getAll();
    //}


    @GetMapping("/students")
      public Page<StudentDTO> getAllStudents(
            @RequestParam(required = false, defaultValue = "0") int pageIndex,
            @RequestParam(required = false, defaultValue = "3") int pageSize
    ) {

        return studentService.getAll(PageRequest.of(pageIndex, pageSize));
    }

    @GetMapping("/students/{studentId}")
    public StudentDTO getStudent(@PathVariable("studentId") long id, @RequestBody Student gettingStudent) {
        return studentService.getById(id);
    }

//    @GetMapping("/students/{username}")
//        public StudentDTO getStudentByUsername(@PathVariable("username") String username){
//            return studentService.getStudentByUsername(username);
//        }


    @PostMapping("/students")
    public Student createStudent(@RequestBody Student editingStudent) {

        return studentService.create(editingStudent);
    }

    @PutMapping("/students/{studentId}")
    public Student updateStudent(@PathVariable("studentId") long id, @RequestBody Student updatingStudent) {
        return studentService.update(id, updatingStudent);
    }

    @DeleteMapping("/students/{studentId}")
    public void deleteStudent(@PathVariable("studentId") long id) {
        studentService.delete(id);
    }


    //@GetMapping("/students/{studentId:\\d+}")
    //public Student getStudentById(@PathVariable("studentId") long id) {
    //    return studentService.getById(id);
    //}

// ёбаный блять
//    @GetMapping("/students/{studentName:\\D+}")
//    public Student getStudentById(@PathVariable("studentName") String name) {
//        return studentService.getByName(name);
//    }
}


