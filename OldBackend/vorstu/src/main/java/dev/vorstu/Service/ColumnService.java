package dev.vorstu.Service;

import dev.vorstu.entity.Column;
import dev.vorstu.repositories.BoardRepository;
import dev.vorstu.repositories.ColumnRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j // log.info
@Service
public class ColumnService {

    @Autowired
    private ColumnRepository columnRepository;

    @Autowired
    private BoardRepository boardRepository;



    public List<Column> getColumnsByBoardId(Long boardId) {

        List<Column> list = columnRepository.getColumnsByBoardId(boardId);
        return list;
    }
}
