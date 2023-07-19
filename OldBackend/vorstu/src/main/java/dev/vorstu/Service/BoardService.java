package dev.vorstu.Service;


import dev.vorstu.Mappers.BoardDataMapper;
import dev.vorstu.Entities.Board;
import dev.vorstu.Entities.BoardDTO;
import dev.vorstu.Repositories.BoardRepository;
import dev.vorstu.Repositories.ColumnRepository;
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
    private ColumnRepository columnRepository;

    public List<BoardDTO> getAll(Long userId) {


        List<BoardDTO> listDTO = boardDataMapper.ListBoardToListBoardDTO(boardRepository.getAllBoards(userId));

        return listDTO;
    }

    public BoardDTO getBoard(Long BoardId) {
         BoardDTO boardDTO = boardDataMapper.BoardToBoardDTO(boardRepository.findById(BoardId).get());
         return boardDTO;
    }



    public Board createNewBoard(Board board){

        return boardRepository.save(board);

    }



}
