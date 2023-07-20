package dev.vorstu.controllers;


import dev.vorstu.service.ColumnService;

import dev.vorstu.entities.ColumnDTO;
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

    @GetMapping("/columns/{id}")
    public List<ColumnDTO> getColumns(@PathVariable("id") Long id) {
       // long boardId = 1L;
        return columnService.getColumnsByBoardId(id);

    }


}
