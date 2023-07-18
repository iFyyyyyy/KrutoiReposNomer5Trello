package dev.vorstu.Mappers;

import dev.vorstu.Entities.Column;
import dev.vorstu.Entities.ColumnDTO;
import dev.vorstu.Entities.Task;
import dev.vorstu.Entities.TaskDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ColumnDataMapper {



    ColumnDataMapper INSTANCE = Mappers.getMapper(ColumnDataMapper.class);
//    @Mapping(source = "tasks", target = "tasksDTO", qualifiedByName = "TaskToTaskDTO")
//    public ColumnDTO ColumnDataMapper(Column column);

    @Mapping(source = "tasks", target = "tasks", qualifiedByName = "TaskToTaskDTO")
    public List<ColumnDTO> ListColumnToListColumnDTO(List<Column> list);


    default TaskDTO TaskToTaskDTO(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setId( task.getId() );
        taskDTO.setTaskName( task.getTaskName() );
        taskDTO.setTaskDescription( task.getTaskDescription() );
        taskDTO.setTaskPosition( task.getTaskPosition() );
        taskDTO.setLastUpdated( task.getLastUpdated() );

        return taskDTO;
    }

    @Named("TaskToTaskDTO")
    default List<TaskDTO> ListTaskToListTaskDTO(List<Task> list) {
        if ( list == null ) {
            return null;
        }

        List<TaskDTO> list1 = new ArrayList<TaskDTO>( list.size() );
        for ( Task task : list ) {
            list1.add( this.TaskToTaskDTO( task ) );
        }

        return list1;
    }

}
