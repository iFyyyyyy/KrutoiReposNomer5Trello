package dev.vorstu.repositories;

import dev.vorstu.entity.Board;
import dev.vorstu.entity.Column;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ColumnRepository extends CrudRepository<Column, Long> {
    List<Column> findAllByOrderByIdAsc();

}
