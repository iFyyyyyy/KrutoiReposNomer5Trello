package dev.vorstu.repositories;

import dev.vorstu.entities.Board;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {
//    @Query("SELECT b FROM boards b")
    @Query("SELECT b FROM Board b  WHERE b.user.id = :userId ORDER BY b.boardPosition ASC")
    List<Board> getAllBoards(@Param("userId") Long userId);

    @Query("SELECT b FROM Board b  WHERE b.boardPosition = :boardPosition")
    Board getBoardByPos(@Param("boardPosition") Long boardPosition);

    @Query("SELECT DISTINCT COUNT (*) FROM Board b WHERE user_id = :userId")
    Long getBoardCount(@Param("userId") Long userId);


}
