package dev.vorstu;

import dev.vorstu.Entities.*;


import dev.vorstu.Repositories.BoardRepository;
import dev.vorstu.Repositories.ColumnRepository;
import dev.vorstu.Repositories.TaskRepository;
import dev.vorstu.Repositories.UserRepository;
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
                1L,
                "Board1",
                "Board1Desc1",
                2L,
                userRepository.findById(1L).get(),
                null,
                true));

        boardRepository.save(new Board(
                2L,
                "Board2",
                "Board2Desc2",
                1L,
                userRepository.findById(1L).get(),
                null,
                true));

        boardRepository.save(new Board(
                3L,
                "Board3",
                "Board3Desc3",
                3L,
                userRepository.findById(1L).get(),
                null,
                true));

        boardRepository.save(new Board(
                4L,
                "Board4",
                "Board4Desc4",
                4L,
                userRepository.findById(1L).get(),
                null,
                true));

        boardRepository.save(new Board(
                5L,
                "Board5",
                "Board5Desc5",
                5L,
                userRepository.findById(1L).get(),
                null,
                true));

        boardRepository.save(new Board(
                6L,
                "Board6",
                "Board6Desc6",
                6L,
                userRepository.findById(1L).get(),
                null,
                true));

        //Columns
        columnRepository.save(new Column(
                1L,
                "    ToDo    ",
                1L,
                boardRepository.findById(2L).get(),
                null
                ));

        columnRepository.save(new Column(
                2L,
                "InProgress",
                2L,
                boardRepository.findById(2L).get(),
                null
                ));

        columnRepository.save(new Column(
                3L,
                "Completed",
                3L,
                boardRepository.findById(2L).get(),
                null
                ));

        columnRepository.save(new Column(
                4L,
                "Column2",
                1L,
                boardRepository.findById(1L).get(),
                null
                ));

        columnRepository.save(new Column(
                5L,
                "Another Column",
                2L,
                boardRepository.findById(1L).get(),
                null
                ));



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

        taskRepository.save(new Task(
                3L,
                "Task3",
                "Task3Column2",
                columnRepository.findById(2L).get(),
                1L,
                new Date()
        ));

        taskRepository.save(new Task(
                4L,
                "Task4",
                "Task4Column3",
                columnRepository.findById(3L).get(),
                2L,
                new Date()
        ));



    }
}
