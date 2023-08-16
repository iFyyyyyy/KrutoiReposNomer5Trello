package dev.vorstu.controllers;


import dev.vorstu.dto.ColumnDTO;
import dev.vorstu.entities.Column;
import dev.vorstu.service.TaskService;
import dev.vorstu.entities.Task;
import dev.vorstu.dto.TaskDTO;
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
    public TaskDTO getTask(@PathVariable("id") Long id) {

        return taskService.getTask(id);
    }

    @PostMapping("/tasks")
    public TaskDTO createNewTask(@RequestParam Long columnId, @RequestBody Task newTask) {
        return taskService.createNewTask(newTask, columnId);
    }

    @PutMapping("/tasks/task/{id}")
    public TaskDTO updateTask(@PathVariable("id") Long taskId,@RequestBody Task updatingTask) {
        return taskService.updateTask(updatingTask, taskId);
    }

    @DeleteMapping("/tasks/task/{id}")
    public void deleteTask(@PathVariable("id") Long taskId) {
        taskService.deleteTask(taskId);
    }

    @PostMapping("/tasks/swap/{taskIndex}/{columnId}")
    public TaskDTO changeColumnPosition(
            @PathVariable("taskIndex") Long taskIndex,
            @PathVariable("columnId") Long columnId,
            @RequestBody Task task){
        return this.taskService.changeTaskPosition(task, taskIndex, columnId);
    }


}