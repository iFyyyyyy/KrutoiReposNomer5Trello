package dev.vorstu.Service;

import dev.vorstu.Mappers.ColumnDataMapper;
import dev.vorstu.Entities.ColumnDTO;
import dev.vorstu.Repositories.ColumnRepository;
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

        List<ColumnDTO> list = columnDataMapper.ListColumnToListColumnDTO(columnRepository.getColumns(boardId));
        return list;
    }
}
