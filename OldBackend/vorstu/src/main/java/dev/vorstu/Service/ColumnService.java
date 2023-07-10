package dev.vorstu.Service;

import dev.vorstu.entity.Board;
import dev.vorstu.entity.Column;
import dev.vorstu.repositories.BoardRepository;
import dev.vorstu.repositories.ColumnRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Slf4j // log.info
@Service
public class ColumnService {

    @Autowired
    private ColumnRepository columnRepository;

    @Autowired
    private BoardRepository boardRepository;

    public List<Column> getColumsByBoardId(Long boardId) {

        Board board = boardRepository.findById(boardId).get();
        List<Column> list = columnRepository.findAllByOrderByIdAsc();
        List<Column> newList = new ArrayList<>();

      //  list.stream().filter(el -> el.getBoard().getId().equals(boardId));
        for (Column column: list
             ) {

            if (column.getBoard() == board){
                newList.add(column);
            }

        }

//        Column column = columnRepository.findById(1L).get();
        log.info("Sending {} columns", board.getBoardName() );
        return newList;
    }
}
