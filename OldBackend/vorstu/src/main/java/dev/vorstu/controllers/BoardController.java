package dev.vorstu.controllers;


import dev.vorstu.service.BoardService;
import dev.vorstu.entities.Board;
import dev.vorstu.entities.BoardDTO;
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

    @PostMapping("/boards")
    public Board createNewBoard(@RequestBody Board newBoard) {

        // curl -X POST "http://localhost:8080/boards" -H "Content-Type: Application/json" {} -v
        return boardService.createNewBoard(newBoard);
    }




}
