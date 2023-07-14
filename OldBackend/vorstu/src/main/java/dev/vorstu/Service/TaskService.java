package dev.vorstu.Service;

import dev.vorstu.entity.Board;
import dev.vorstu.entity.Column;
import dev.vorstu.entity.Task;
import dev.vorstu.repositories.BoardRepository;
import dev.vorstu.repositories.ColumnRepository;
import dev.vorstu.repositories.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j // log.info
@Service
public class TaskService {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    ColumnRepository columnRepository;

    @Autowired
    TaskRepository taskRepository;

    public List<Task> getTasksByBoardId(Long columnId) {

        List<Task> list = taskRepository.getTasksByBoardId(columnId);

        return  list;
    }
}