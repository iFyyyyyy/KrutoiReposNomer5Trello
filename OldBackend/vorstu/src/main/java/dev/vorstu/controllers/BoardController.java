package dev.vorstu.controllers;


import dev.vorstu.Service.BoardService;
import dev.vorstu.entity.Board;
import dev.vorstu.entity.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j // log.info
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class BoardController {



    @Autowired
    private BoardService boardService;


    @GetMapping("/boards/{id}")
    public List<Board> getTasks(@PathVariable("id") Long userId) {
        return boardService.getAll(userId);
    }


}
