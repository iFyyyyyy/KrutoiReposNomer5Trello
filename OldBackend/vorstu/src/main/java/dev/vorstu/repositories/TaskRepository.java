package dev.vorstu.repositories;

import dev.vorstu.entities.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {

    @Query("SELECT DISTINCT t FROM Task t WHERE t.column.board.id = :boardId")
    List<Task> getTasksByBoardId(@Param("boardId") Long boardId);

    @Query("SELECT DISTINCT COUNT (*) FROM Task t WHERE column_id = :columnId")
    Long getTasksCount(@Param("columnId") Long columnId);

    @Query("SELECT t FROM Task t WHERE column_id = :columnId")
    List<Task> getTasksByColumnId(@Param("columnId") Long columnId);
}

