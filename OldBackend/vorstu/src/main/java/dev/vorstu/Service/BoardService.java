package dev.vorstu.Service;

import dev.vorstu.entity.Board;
import dev.vorstu.repositories.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public List<Board> getAll() {
        List<Board> list = boardRepository.findAllByOrderByIdDesc();
        return list;
    }
}
