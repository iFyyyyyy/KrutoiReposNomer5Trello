package dev.vorstu.repositories;

import dev.vorstu.entity.Column;
import dev.vorstu.entity.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {

    @Query(value= "select t.id,t.last_updated,t.taskname, t.task_description, t.task_position, t.column_id " +
            "from tasks t " +
            "where t.column_id =:columnId",  nativeQuery = true)
    List<Task> getTasksByBoardId(@Param("columnId")Long columnId);
}
