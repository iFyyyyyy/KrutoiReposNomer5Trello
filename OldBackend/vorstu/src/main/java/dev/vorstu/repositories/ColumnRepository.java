package dev.vorstu.repositories;

import dev.vorstu.entities.Column;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface ColumnRepository extends CrudRepository<Column, Long> {

    //List<Column> findAllByOrderByIdAsc();

    @Query("SELECT DISTINCT c FROM Column c LEFT JOIN FETCH c.tasks WHERE board_id = :boardId ORDER BY c.columnPosition ASC")
    List<Column> getColumns(@Param("boardId") Long boardId);

    @Query("SELECT DISTINCT COUNT (*) FROM Column c WHERE board_id = :boardId")
    Long getColumnsCount(@Param("boardId") Long boardId);

    // посмотреть что такое eager и lazy
}

