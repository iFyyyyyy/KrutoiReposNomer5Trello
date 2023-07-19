package dev.vorstu.Controllers;


import dev.vorstu.Service.BoardService;
import dev.vorstu.Entities.Board;
import dev.vorstu.Entities.BoardDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j // log.info
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class BoardController {



    @Autowired
    private BoardService boardService;


    @GetMapping("/boards/{id}")
    public List<BoardDTO> getAllBoards(@PathVariable("id") Long userId) {

        return boardService.getAll(userId);
    }

    @GetMapping("/boards/board/{id}")
    public BoardDTO getBoard(@PathVariable("id") Long boardId) {

        return boardService.getBoard(boardId);
    }

    @PostMapping("/students")
    public Board createNewBoard(@RequestBody Board newBoard) {

        return boardService.createNewBoard(newBoard);
    }




}
