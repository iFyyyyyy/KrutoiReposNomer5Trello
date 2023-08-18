package dev.vorstu.service;

import dev.vorstu.dto.BoardDTO;
import dev.vorstu.entities.Board;
import dev.vorstu.entities.Column;
import dev.vorstu.mappers.ColumnDataMapper;
import dev.vorstu.dto.ColumnDTO;
import dev.vorstu.repositories.BoardRepository;
import dev.vorstu.repositories.ColumnRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j // log.info
@Service
public class ColumnService {

    @Autowired
    private ColumnRepository columnRepository;

    @Autowired
    private ColumnDataMapper columnDataMapper;

    @Autowired
    private BoardRepository boardRepository;



    public List<ColumnDTO> getColumnsByBoardId(Long boardId) {
        List<Column> columns = columnRepository.getColumns(boardId);

        List<ColumnDTO> list = columnDataMapper.ListColumnToListColumnDTO(columns);
        return list;
    }

    public ColumnDTO createNewColumn(Column newColumn, Long boardId){
        newColumn.setId(null);
        newColumn.setTasks(null);
        newColumn.setColumnPosition(columnRepository.getColumnsCount(boardId)+1L);
        newColumn.setBoard(boardRepository.findById(boardId).get());
        columnRepository.save(newColumn);

        return columnDataMapper.columnToColumnDTO(newColumn);
    }

    public ColumnDTO updateColumn(Column updatingColumn, Long columnId){
        Column column = columnRepository.findById(columnId).get();
        column.setColumnName(updatingColumn.getColumnName());
        //column.setColumnPosition(updatingColumn.getColumnPosition());
        columnRepository.save(column);

        return columnDataMapper.columnToColumnDTO(column);
    }

    public void deleteColumn(Long boardId) {
        boardRepository.deleteById(boardId);
    }

    public List<ColumnDTO> changeColumnPosition(Column column, Long columnIndex, Long boardId){
        List<Column> columns = columnRepository.getColumns(boardId);

        Column removed = columns.remove(Math.toIntExact(column.getColumnPosition()-1));
        columns.add(Math.toIntExact(columnIndex), removed);

        Long counter = 1L;
        for (Column column1: columns){
            column1.setColumnPosition(counter++);
            this.columnRepository.save(column1);
        }
        return this.getColumnsByBoardId(boardId);
    }
}
