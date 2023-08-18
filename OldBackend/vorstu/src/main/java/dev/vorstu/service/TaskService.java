package dev.vorstu.service;

import dev.vorstu.dto.ColumnDTO;
import dev.vorstu.entities.Column;
import dev.vorstu.mappers.TaskDataMapper;
import dev.vorstu.entities.Task;
import dev.vorstu.dto.TaskDTO;
import dev.vorstu.repositories.ColumnRepository;
import dev.vorstu.repositories.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j // log.info
@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    TaskDataMapper taskDataMapper;

    @Autowired
    ColumnRepository columnRepository;

    @Autowired
    ColumnService columnService;

    public List<TaskDTO> getTasks(Long id) {
        List<TaskDTO> list = taskDataMapper.ListTaskToListTaskDTO(taskRepository.getTasksByBoardId(id));
        return  list;
    }

//    public List<TaskDTO> getTasksByColumnId(Long id) {
//        List<TaskDTO> list = taskDataMapper.ListTaskToListTaskDTO(taskRepository.getTasksByColumnId(id));
//        return  list;
//    }

    public TaskDTO getTask(Long Id) {
        TaskDTO task = taskDataMapper.TaskToTaskDTO(taskRepository.findById(Id).get());
        return task;
    }

    public TaskDTO createNewTask(Task newTask, Long columnId){
        newTask.setId(null);
        newTask.setTaskPosition(taskRepository.getTasksCount(columnId));
        newTask.setColumn(columnRepository.findById(columnId).get());
        taskRepository.save(newTask);

        return taskDataMapper.TaskToTaskDTO(newTask);
    }

    public TaskDTO updateTask(Task updatingTask, Long taskId){

        Task task = taskRepository.findById(taskId).get();
        task.setTaskName(updatingTask.getTaskName());
        task.setTaskDescription(updatingTask.getTaskDescription());
        task.setLastUpdated(updatingTask.getLastUpdated());
        taskRepository.save(task);

        return taskDataMapper.TaskToTaskDTO(task);
    }

    public void deleteTask(Long taskId){
        taskRepository.deleteById(taskId);
    }

    // Закидывает в конец, потому что я уже на 79 сохраняю в репозиторий, и при след методе он УЖЕ на посл месте.
    public List<ColumnDTO> changeTaskPosition(Task updatingTask, Long taskIndex, Long columnId) {
        Task task = taskRepository.findById(updatingTask.getId()).get();
        Column column = this.getColumn(columnId);
        if (task.getColumn() != column) {
            taskRepository.delete(task);
            this.changePosition(taskRepository.getTasksByColumnId(task.getColumn().getId()));
            task.setColumn(column);
            taskRepository.save(task);
            this.swapTasksPosition(updatingTask, taskIndex, columnId, true);
        }
        else {
            this.swapTasksPosition(updatingTask, taskIndex, columnId, false);
        }
        return columnService.getColumnsByBoardId(column.getBoard().getId());
    }

    Column getColumn(Long columnId){
        return columnRepository.findById(columnId).get();
    }

    void changePosition(List<Task> tasks){
        Long counter = 1L;
        for (Task task1 : tasks) {
            task1.setTaskPosition(counter++);
            this.taskRepository.save(task1);
        }
    }

    void swapTasksPosition(Task updatingTask, Long taskIndex, Long columnId, boolean isSwitchedColumn) {
        List<Task> tasks = taskRepository.getTasksByColumnId(columnId);
        if(!isSwitchedColumn) {
            Task removed = tasks.remove(Math.toIntExact(updatingTask.getTaskPosition()-1));
            tasks.add(Math.toIntExact(taskIndex), removed);
            this.changePosition(tasks);
        }
        else {
            this.changePosition(tasks);
        }
    }
}



