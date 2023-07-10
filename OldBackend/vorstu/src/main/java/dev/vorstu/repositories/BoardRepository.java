package dev.vorstu.repositories;

import dev.vorstu.entity.Board;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {
    List<Board> findAllByOrderByIdDesc();

}
