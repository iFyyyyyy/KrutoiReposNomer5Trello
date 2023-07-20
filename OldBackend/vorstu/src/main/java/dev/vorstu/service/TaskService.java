package dev.vorstu.service;

import dev.vorstu.mappers.TaskDataMapper;
import dev.vorstu.entities.Task;
import dev.vorstu.entities.TaskDTO;
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
    TaskDataMapper taskDataMapper;

    public List<TaskDTO> getTasks(Long Id) {

        List<TaskDTO> list = taskDataMapper.ListTaskToListTaskDTO(taskRepository.getTasksByBoardId(Id));

        return  list;
    }

    public Task getTask(Long Id) {

        Task task = taskRepository.findById(Id).get();

        return task;
    }
}