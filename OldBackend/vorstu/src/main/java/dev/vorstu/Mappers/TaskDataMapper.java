package dev.vorstu.Mappers;


import dev.vorstu.Entities.Task;
import dev.vorstu.Entities.TaskDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskDataMapper {

    TaskDataMapper INSTANCE = Mappers.getMapper(TaskDataMapper.class);

    TaskDTO TaskToTaskDTO (Task task);

    List<TaskDTO> ListTaskToListTaskDTO (List<Task> list);

}
