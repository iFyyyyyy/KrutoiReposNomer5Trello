package dev.vorstu.Service;

import dev.vorstu.entity.Board;
import dev.vorstu.entity.Column;
import dev.vorstu.entity.Task;
import dev.vorstu.repositories.BoardRepository;
import dev.vorstu.repositories.ColumnRepository;
import dev.vorstu.repositories.TaskRepository;
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
    private ColumnRepository columnRepository;

    public List<Board> getAll() {
        List<Board> list = boardRepository.findAllByOrderByIdAsc();

        log.info("Sending boards");
        return list;
    }


}
