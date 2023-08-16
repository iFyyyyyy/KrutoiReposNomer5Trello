package dev.vorstu.controllers;


import dev.vorstu.mappers.BoardDataMapper;
import dev.vorstu.service.BoardService;
import dev.vorstu.entities.Board;
import dev.vorstu.dto.BoardDTO;
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

    @Autowired
    private BoardDataMapper boardDataMapper;

    @GetMapping("/boards/{id}")
    public List<BoardDTO> getAllBoards(@PathVariable("id") Long userId) {

        return boardService.getAll(userId);
    }

    @GetMapping("/boards/board/{id}")
    public BoardDTO getBoard(@PathVariable("id") Long boardId) {

        return boardService.getBoard(boardId);
    }

    @PostMapping("/boards")
    public BoardDTO createNewBoard( @RequestParam Long userId,@RequestBody Board newBoard) {

        Board board = boardService.createNewBoard(newBoard, userId);

        return boardDataMapper.BoardToBoardDTO(board);
    }

    @PutMapping("/boards/board/{id}")
    public BoardDTO updateBoard(@PathVariable("id") Long boardId,@RequestBody Board updatingBoard) {

        Board board = boardService.updateBoard(updatingBoard, boardId);

        return boardDataMapper.BoardToBoardDTO(board);
    }

    @DeleteMapping("/boards/board/{id}")
    public void deleteBoard(@PathVariable("id") Long boardId) {
         boardService.deleteBoard(boardId);
    }

    @PostMapping("/boards/swap/{boardIndex}")
    public List<BoardDTO> changeBoardPosition(@PathVariable("boardIndex") Long boardIndex, @RequestBody Board board){

        return this.boardService.boardPositionSwap(board, boardIndex);
    }


}
