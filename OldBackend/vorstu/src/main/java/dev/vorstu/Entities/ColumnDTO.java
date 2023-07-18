package dev.vorstu.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ColumnDTO {
    private Long id;
    private String columnName;
    private Long columnPosition;
    private List<TaskDTO> tasks;

}
