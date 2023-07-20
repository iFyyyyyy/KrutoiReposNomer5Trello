package dev.vorstu.mappers;


import dev.vorstu.entities.Task;
import dev.vorstu.entities.TaskDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

//@Qualifier
//@Target(ElementType.METHOD)
//@Retention(RetentionPolicy.CLASS)
@Mapper(componentModel = "spring")
public interface TaskDataMapper {

    TaskDataMapper INSTANCE = Mappers.getMapper(TaskDataMapper.class);

    TaskDTO TaskToTaskDTO (Task task);

    //@ListTaskToListTaskDTOMapper
    List<TaskDTO> ListTaskToListTaskDTO (List<Task> list);

}
