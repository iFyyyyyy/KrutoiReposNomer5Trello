package dev.vorstu;

import dev.vorstu.entities.*;


import dev.vorstu.repositories.BoardRepository;
import dev.vorstu.repositories.ColumnRepository;
import dev.vorstu.repositories.TaskRepository;
import dev.vorstu.repositories.UserRepository;
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
                null,
                //user.SetPassword("1234"),
                true));

        //Boards
        boardRepository.save(new Board(
                null,
                "Board1",
                "Board1Desc1",
                1L,
                userRepository.findById(1L).get(),
                null,
                true));

        boardRepository.save(new Board(
                null,
                "Board2",
                "Board2Desc2",
                2L,
                userRepository.findById(1L).get(),
                null,
                true));

        boardRepository.save(new Board(
                null,
                "Board3",
                "Board3Desc3",
                3L,
                userRepository.findById(1L).get(),
                null,
                true));

//        boardRepository.save(new Board(
//                null,
//                "Board4",
//                "Board4Desc4",
//                4L,
//                userRepository.findById(1L).get(),
//                null,
//                true));
//
//        boardRepository.save(new Board(
//                null,
//                "Board5",
//                "Board5Desc5",
//                5L,
//                userRepository.findById(1L).get(),
//                null,
//                true));
//
//        boardRepository.save(new Board(
//                null,
//                "Board6",
//                "Board6Desc6",
//                6L,
//                userRepository.findById(1L).get(),
//                null,
//                true));

        //Columns
        columnRepository.save(new Column(
                null,
                "To Do",
                1L,
                boardRepository.findById(2L).get(),
                null
                ));

        columnRepository.save(new Column(
                null,
                "In Progress",
                2L,
                boardRepository.findById(2L).get(),
                null
                ));

        columnRepository.save(new Column(
                null,
                "Completed",
                3L,
                boardRepository.findById(2L).get(),
                null
                ));

        columnRepository.save(new Column(
                null,
                "Column1Board2",
                1L,
                boardRepository.findById(1L).get(),
                null
                ));

        columnRepository.save(new Column(
                null,
                "Column2Board1",
                2L,
                boardRepository.findById(1L).get(),
                null
                ));


        // Tasks
        taskRepository.save(new Task(
                null,
                "Task1",
                "Task1Column1_ToDo",
                columnRepository.findById(1L).get(),
                1L,
                new Date()
        ));

        taskRepository.save(new Task(
                null,
                "Task2",
                "Task2Column1_ToDo",
                columnRepository.findById(1L).get(),
                2L,
                new Date()
        ));

        taskRepository.save(new Task(
                null,
                "Task3",
                "Task3Column2",
                columnRepository.findById(2L).get(),
                1L,
                new Date()
        ));

        taskRepository.save(new Task(
                null,
                "Task4",
                "Task4Column3",
                columnRepository.findById(3L).get(),
                2L,
                new Date()
        ));
        taskRepository.save(new Task(
                null,
                "Task5",
                "Task5Column4",
                columnRepository.findById(4L).get(),
                1L,
                new Date()
        ));



    }
}
