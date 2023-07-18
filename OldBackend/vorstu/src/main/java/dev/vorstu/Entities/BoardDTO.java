package dev.vorstu.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {

    private Long id;

    private String boardName;

    private String boardDescription;

    private Long boardPosition;

    private boolean IsPublic;

}
