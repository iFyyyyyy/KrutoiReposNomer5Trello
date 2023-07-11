package dev.vorstu.controllers;


import dev.vorstu.Service.ColumnService;

import dev.vorstu.entity.Column;
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

    @PostMapping("/columns")
    public List<Column> getColumns(@RequestBody long id) {
       // long boardId = 1L;
        return columnService.getColumnsByBoardId(id);

    }


}
