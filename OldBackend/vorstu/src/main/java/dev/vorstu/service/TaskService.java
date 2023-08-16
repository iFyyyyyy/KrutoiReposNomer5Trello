package dev.vorstu.service;

import dev.vorstu.mappers.TaskDataMapper;
import dev.vorstu.entities.Task;
import dev.vorstu.dto.TaskDTO;
import dev.vorstu.repositories.ColumnRepository;
import dev.vorstu.repositories.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j // log.info
@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    ColumnRepository columnRepository;

    @Autowired
    TaskDataMapper taskDataMapper;

    public List<TaskDTO> getTasks(Long Id) {
        List<TaskDTO> list = taskDataMapper.ListTaskToListTaskDTO(taskRepository.getTasksByBoardId(Id));
        return  list;
    }

    public TaskDTO getTask(Long Id) {
        TaskDTO task = taskDataMapper.TaskToTaskDTO(taskRepository.findById(Id).get());
        return task;
    }

    public TaskDTO createNewTask(Task newTask, Long columnId){
        newTask.setId(null);
        newTask.setTaskPosition(taskRepository.getTasksCount(columnId));
        newTask.setColumn(columnRepository.findById(columnId).get());
        taskRepository.save(newTask);

        return taskDataMapper.TaskToTaskDTO(newTask);
    }

    public TaskDTO updateTask(Task updatingTask, Long taskId){
        return new TaskDTO();
    }

    public void deleteTask(Long taskId){
    }

    public TaskDTO changeTaskPosition(Task updatingTask, Long taskIndex, Long columnId){
        return new TaskDTO();
    }



}