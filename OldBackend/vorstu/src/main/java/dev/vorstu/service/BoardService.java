package dev.vorstu.service;


//import dev.vorstu.mappers.BoardDataMapper;
import dev.vorstu.dto.UserDTO;
import dev.vorstu.entities.Board;
import dev.vorstu.dto.BoardDTO;
import dev.vorstu.entities.Column;
import dev.vorstu.mappers.BoardDataMapper;
import dev.vorstu.repositories.BoardRepository;
import dev.vorstu.repositories.ColumnRepository;
import dev.vorstu.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ColumnRepository columnRepository;

    @Autowired
    private BoardDataMapper boardDataMapper;

    @Autowired
    private UserRepository userRepository;

    public List<BoardDTO> getAll() {
        UserDTO auth = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getDetails();
        List<BoardDTO> listDTO = boardDataMapper.ListBoardToListBoardDTO(boardRepository.getAllBoards(auth.getId()));
        return listDTO;
    }

    public BoardDTO getBoard(Long BoardId) {
         BoardDTO boardDTO = boardDataMapper.BoardToBoardDTO(boardRepository.findById(BoardId).get());
         return boardDTO;
    }



    public Board createNewBoard(Board board){
        UserDTO auth = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getDetails();
        board.setId(null);
        board.setUser(userRepository.findById(auth.getId()).get());
        board.setBoardPosition(boardRepository.getBoardCount(auth.getId())+1L);
        board.setColumns(listOfNewColumns(board));
        return boardRepository.save(board);
    }

    List<Column> listOfNewColumns(Board board){
        ArrayList list = new ArrayList<Column>();
        list.add(new Column(null,"To Do",1L, board,null));
        list.add(new Column(null,"In Progress",2L, board,null));
        list.add(new Column(null,"Finished",3L, board,null));
        return list;
    }

    public Board updateBoard(Board updatingBoard, Long boardId){

        if (boardRepository.existsById(boardId)){
            log.info("cant find board");
        }
        Board board = boardRepository.findById(boardId).get();
        board.setBoardName(updatingBoard.getBoardName());
        board.setBoardDescription(updatingBoard.getBoardDescription());
        board.setPrivate(updatingBoard.isPrivate());

        return boardRepository.save(board);
    }

    public void deleteBoard(Long boardId) {
        if (boardRepository.existsById(boardId)){
            log.info("cant find board");
        }
        boardRepository.deleteById(boardId);
    }

    public List<BoardDTO> boardPositionSwap(Board board, Long boardIndex){
        //UserDTO auth = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getDetails();
        List<Board> boards = boardRepository.getAllBoards(1L);

        Board removed = boards.remove(Math.toIntExact(board.getBoardPosition()-1));
        //removed.setBoardPosition(boardIndex+1);
        boards.add(Math.toIntExact(boardIndex), removed);

        Long counter = 1L;
        for (Board board1: boards){
            board1.setBoardPosition(counter++);
            this.boardRepository.save(board1);
        }
        return this.getAll();
    }




//    public boolean boardPositionSwap(List<Board> boards){
//
//        if(!Objects.equals(boards.get(0).getId(), boards.get(1).getId())) {
//            Board droppedBoard = this.boardRepository.findById(boards.get(0).getId()).get();
//            Board secondBoard = this.boardRepository.findById(boards.get(1).getId()).get();
//
//            Long tempPosition = droppedBoard.getBoardPosition();
//            droppedBoard.setBoardPosition(secondBoard.getBoardPosition());
//            secondBoard.setBoardPosition(tempPosition);
//
//            this.boardRepository.save(droppedBoard);
//            this.boardRepository.save(secondBoard);
//
//            return true;
//        }
//        else return false;
//    }






}
