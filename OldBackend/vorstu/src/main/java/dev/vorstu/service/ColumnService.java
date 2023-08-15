package dev.vorstu.service;

import dev.vorstu.entities.Column;
import dev.vorstu.mappers.ColumnDataMapper;
import dev.vorstu.dto.ColumnDTO;
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



    public List<ColumnDTO> getColumnsByBoardId(Long boardId) {
        List<Column> columns = columnRepository.getColumns(boardId);

        List<ColumnDTO> list = columnDataMapper.ListColumnToListColumnDTO(columns);
        return list;
    }
}
