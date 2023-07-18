package dev.vorstu.Mappers;


import dev.vorstu.Entities.Board;
import dev.vorstu.Entities.BoardDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BoardDataMapper {
    BoardDataMapper INSTANCE = Mappers.getMapper(BoardDataMapper.class);

    BoardDTO BoardToBoardDTO(Board board);
    List<BoardDTO> ListBoardToListBoardDTO(List<Board> list);
}
