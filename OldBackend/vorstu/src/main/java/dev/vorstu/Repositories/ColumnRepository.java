package dev.vorstu.Repositories;

import dev.vorstu.Entities.Column;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ColumnRepository extends CrudRepository<Column, Long> {
    List<Column> findAllByOrderByIdAsc();

    //@Query("SELECT columnName FROM columns WHERE columns.board_id = :boardId")
//    @Query(value= "select c.column_name, c.column_position from columns c where c.board_id =:boardId",  nativeQuery = true)
//    List<Column> getColumnsByBoardId(@Param("boardId") Long boardId);
//    @Query(value= "select c.id, c.column_name, c.column_position, c.board_id " +
//            "from columns c " +
//            "where c.board_id =:boardId",  nativeQuery = true)
//    List<Column> getColumnsByBoardId(@Param("boardId")Long boardId);

    @Query("SELECT c FROM Column c WHERE c.board.id = :boardId ORDER BY c.columnPosition ASC")
    List<Column> getColumns(@Param("boardId") Long boardId);

}


