package dev.vorstu.controllers;


import dev.vorstu.dto.BoardDTO;
import dev.vorstu.entities.Board;
import dev.vorstu.entities.Column;
import dev.vorstu.mappers.ColumnDataMapper;
import dev.vorstu.service.ColumnService;

import dev.vorstu.dto.ColumnDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j // log.info
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ColumnController {

    @Autowired
    private ColumnService columnService;

    @Autowired
    private ColumnDataMapper columnDataMapper;

    @GetMapping("/columns/{id}")
    public List<ColumnDTO> getColumns(@PathVariable("id") Long id) {
        return columnService.getColumnsByBoardId(id);
    }

    @PostMapping("/columns")
    public ColumnDTO createNewColumn(@RequestParam Long boardId, @RequestBody Column newColumn) {
        return columnService.createNewColumn(newColumn, boardId);
    }

    @PutMapping("/columns/column/{id}")
    public ColumnDTO updateColumn(@PathVariable("id") Long columnId,@RequestBody Column updatingColumn) {
        return columnService.updateColumn(updatingColumn, columnId);
    }

    @DeleteMapping("/columns/column/{id}")
    public void deleteColumn(@PathVariable("id") Long columnId) {
            columnService.deleteColumn(columnId);
    }

    @PostMapping("/columns/swap/{columnIndex}/{boardId}")
    public List<ColumnDTO> changeColumnPosition(
            @PathVariable("columnIndex") Long columnIndex,
            @PathVariable("boardId") Long boardId,
            @RequestBody Column column){
        return this.columnService.changeColumnPosition(column, columnIndex, boardId);
    }

}
