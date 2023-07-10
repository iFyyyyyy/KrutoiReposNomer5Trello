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

    @PostMapping("/tasks")
    public List<Task> getColumns(@RequestBody long id) {
        // long boardId = 1L;
        return taskService.getTasks(id);

    }


}