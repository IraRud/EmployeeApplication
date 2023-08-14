package ru.skypro.lesson.springboot.EmployeeApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.skypro.lesson.springboot.EmployeeApplication.model.Position;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PositionDTO {
    private Integer id;
    private String name;

    public static PositionDTO fromPosition(Position position) {
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setId(position.getId());
        positionDTO.setName(position.getName());
        return positionDTO;
    }

    public Position toPosition() {
        Position position = new Position();
        position.setId(this.getId());
        position.setName(this.getName());
        return position;
    }
}

