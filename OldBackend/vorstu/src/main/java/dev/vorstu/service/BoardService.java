package dev.vorstu.service;


//import dev.vorstu.mappers.BoardDataMapper;
import dev.vorstu.entities.Board;
import dev.vorstu.entities.BoardDTO;
import dev.vorstu.mappers.BoardDataMapper;
import dev.vorstu.repositories.BoardRepository;
import dev.vorstu.repositories.ColumnRepository;
import dev.vorstu.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;


    @Autowired
    private BoardDataMapper boardDataMapper;

    @Autowired
    private UserRepository userRepository;

    public List<BoardDTO> getAll(Long userId) {


        List<BoardDTO> listDTO = boardDataMapper.ListBoardToListBoardDTO(boardRepository.getAllBoards(userId));

        return listDTO;
    }

    public BoardDTO getBoard(Long BoardId) {
         BoardDTO boardDTO = boardDataMapper.BoardToBoardDTO(boardRepository.findById(BoardId).get());
         return boardDTO;
    }



    public Board createNewBoard(Board board, Long userId){

        board.setId(null);
        board.setUser(userRepository.findById(userId).get());
        board.setBoardPosition(boardRepository.count());
        board.setColumns(null);
        return boardRepository.save(board);

    }

    public Board updateBoard(Board updatingBoard, Long boardId){

        if (boardRepository.existsById(boardId)){
            log.info("cant find board");
        }
        Board board = boardRepository.findById(boardId).get();
        board.setBoardName(updatingBoard.getBoardName());
        board.setBoardDescription(updatingBoard.getBoardDescription());
        board.setIsPrivate(updatingBoard.isIsPrivate());

        return boardRepository.save(board);
    }

    public void deleteBoard(Long boardId) {
        if (boardRepository.existsById(boardId)){
            log.info("cant find board");
        }
        boardRepository.deleteById(boardId);
    }





}
