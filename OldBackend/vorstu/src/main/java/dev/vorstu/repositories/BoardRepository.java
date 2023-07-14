package dev.vorstu.repositories;

import dev.vorstu.entity.Board;
import dev.vorstu.entity.Column;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {
//    @Query("SELECT b FROM boards b")
    @Query("SELECT b FROM board b WHERE b.user.id = :userId ORDER BY b.id ASC")
    List<Board> getBoardsByUserId(@Param("userId") Long userId);

}
