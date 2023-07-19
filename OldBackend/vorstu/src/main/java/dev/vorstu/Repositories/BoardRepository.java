package dev.vorstu.Repositories;

import dev.vorstu.Entities.Board;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {
//    @Query("SELECT b FROM boards b")
    @Query("SELECT b FROM Board b WHERE b.user.id = :userId ORDER BY b.boardPosition ASC")
    List<Board> getAllBoards(@Param("userId") Long userId);


}
