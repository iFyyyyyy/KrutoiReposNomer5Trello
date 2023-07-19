package dev.vorstu.Mappers;


import dev.vorstu.Entities.Task;
import dev.vorstu.Entities.TaskDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Qualifier;
import org.mapstruct.factory.Mappers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
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
