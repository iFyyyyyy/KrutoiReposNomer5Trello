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

    public List<Task> getTasks(Long boardId) {

        Board board = boardRepository.findById(boardId).get();

        List<Column> list = columnRepository.findAllByOrderByIdAsc();
        List<Task> TaskList = (List<Task>) taskRepository.findAll();
        List<Task> newList = new ArrayList<>();

        for (Column column: list) {
            if (column.getBoard() == board){
                for (Task task: TaskList
                     ) {
                    if(task.getColumn() == column){
                        newList.add(task);
                    }

                }

            }
        }

//        Column column = columnRepository.findById(1L).get();
//        log.info("Sending {} columns", board.getBoardName() );
        return newList;
    }
}