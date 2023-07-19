package dev.vorstu.Mappers;

import dev.vorstu.Entities.Column;
import dev.vorstu.Entities.ColumnDTO;
import dev.vorstu.Entities.Task;
import dev.vorstu.Entities.TaskDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ColumnDataMapper {

    TaskDataMapper taskDataMapper = new TaskDataMapperImpl();

    ColumnDataMapper INSTANCE = Mappers.getMapper(ColumnDataMapper.class);

    @Mapping(source = "tasks", target = "tasks", qualifiedByName = "TaskToTaskDTO")
    public List<ColumnDTO> ListColumnToListColumnDTO(List<Column> list);

    @Named("TaskToTaskDTO")
    default List<TaskDTO> ColumnToColumnDTO(List<Task> list){

        return taskDataMapper.ListTaskToListTaskDTO(list);

    }


}
