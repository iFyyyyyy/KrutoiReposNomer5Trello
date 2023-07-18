package dev.vorstu.Controllers;


import dev.vorstu.Service.TaskService;
import dev.vorstu.Entities.Task;
import dev.vorstu.Entities.TaskDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j // log.info
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks/{id}")
    public List<TaskDTO> getTasks(@PathVariable("id") Long id) {

        return taskService.getTasks(id);
    }

    @GetMapping("/tasks/task/{id}")
    public Task getTask(@PathVariable("id") Long id) {

        return taskService.getTask(id);
    }

//    @PostMapping("/students")
//    public Student createStudent(@RequestBody Student editingStudent) {
//
//        return studentService.create(editingStudent);
//    }
//
//    @PutMapping("/students/{studentId}")
//    public Student updateStudent(@PathVariable("studentId") long id, @RequestBody Student updatingStudent) {
//        return studentService.update(id, updatingStudent);
//    }
//
//    @DeleteMapping("/students/{studentId}")
//    public void deleteStudent(@PathVariable("studentId") long id) {
//        studentService.delete(id);
//    }



}