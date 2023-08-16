package dev.vorstu.mappers;

import dev.vorstu.entities.Column;
import dev.vorstu.dto.ColumnDTO;
import dev.vorstu.entities.Task;
import dev.vorstu.dto.TaskDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ColumnDataMapper {

    TaskDataMapper taskDataMapper = new dev.vorstu.mappers.TaskDataMapperImpl();

    ColumnDataMapper INSTANCE = Mappers.getMapper(ColumnDataMapper.class);

    @Mapping(source = "tasks", target = "tasks", qualifiedByName = "TaskToTaskDTO")
    ColumnDTO columnToColumnDTO(Column column);

    @Mapping(source = "tasks", target = "tasks", qualifiedByName = "TaskToTaskDTO")
    public List<ColumnDTO> ListColumnToListColumnDTO(List<Column> list);

    @Named("TaskToTaskDTO")
    default List<TaskDTO> TaskToTaskDTO(List<Task> list){

        return taskDataMapper.ListTaskToListTaskDTO(list);

    }


}
