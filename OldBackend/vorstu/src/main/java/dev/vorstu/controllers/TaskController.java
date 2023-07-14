package dev.vorstu.controllers;


import dev.vorstu.Service.ColumnService;

import dev.vorstu.Service.TaskService;
import dev.vorstu.entity.Column;
import dev.vorstu.entity.Task;
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
    public List<Task> getTasks(@PathVariable("id") Long id) {

        return taskService.getTasksByBoardId(id);
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