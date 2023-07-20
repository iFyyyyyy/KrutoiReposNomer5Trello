package dev.vorstu.mappers;

import dev.vorstu.entities.Column;
import dev.vorstu.entities.ColumnDTO;
import dev.vorstu.entities.Task;
import dev.vorstu.entities.TaskDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface ColumnDataMapper {

    TaskDataMapper taskDataMapper = new dev.vorstu.mappers.TaskDataMapperImpl();

    ColumnDataMapper INSTANCE = Mappers.getMapper(ColumnDataMapper.class);

    @Mapping(source = "tasks", target = "tasks", qualifiedByName = "TaskToTaskDTO")
    public List<ColumnDTO> ListColumnToListColumnDTO(List<Column> list);

    @Named("TaskToTaskDTO")
    default List<TaskDTO> ColumnToColumnDTO(List<Task> list){

        return taskDataMapper.ListTaskToListTaskDTO(list);

    }


}
