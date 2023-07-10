package dev.vorstu;

import dev.vorstu.entity.*;

import dev.vorstu.repositories.TaskRepository;
import dev.vorstu.repositories.ColumnRepository;
import dev.vorstu.repositories.BoardRepository;
import dev.vorstu.repositories.UserRepository;
import jdk.nashorn.internal.runtime.Undefined;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Initializer {


    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private ColumnRepository columnRepository;



    public void initial() {
        User user = new User();

        //Users
        userRepository.save(new User(
                1L,
                "user1",
                Role.USER,
                "1234",
                //user.SetPassword("1234"),
                true));

        //Boards
        boardRepository.save(new Board(
                1L,
                "Board1",
                "Board1Desc1",
                userRepository.findById(1L).get(),
                true));

        boardRepository.save(new Board(
                2L,
                "Board2",
                "Board2Desc2",
                userRepository.findById(1L).get(),
                true));
//
//        boardRepository.save(new Board(
//                3L,
//                "Board3",
//                "Board3Desc3",
//                userRepository.findById(1L).get(),
//                true));
//
//        boardRepository.save(new Board(
//                4L,
//                "Board4",
//                "Board4Desc4",
//                userRepository.findById(1L).get(),
//                true));

        //Columns
        columnRepository.save(new Column(
                1L,
                "ToDo      ",
                boardRepository.findById(1L).get(),
                1L));

        columnRepository.save(new Column(
                2L,
                "InProgress",
                boardRepository.findById(1L).get(),
                2L));

        columnRepository.save(new Column(
                3L,
                "Completed",
                boardRepository.findById(1L).get(),
                3L));

        columnRepository.save(new Column(
                4L,
                "Column2",
                boardRepository.findById(2L).get(),
                3L));

        columnRepository.save(new Column(
                5L,
                "Another Column",
                boardRepository.findById(2L).get(),
                3L));



        taskRepository.save(new Task(
                1L,
                "Task1",
                "Task1Column1_ToDo",
                columnRepository.findById(1L).get(),
                1L,
                new Date()
        ));

        taskRepository.save(new Task(
                2L,
                "Task2",
                "Task2Column1_ToDo",
                columnRepository.findById(1L).get(),
                2L,
                new Date()
        ));



    }
}
