package io.swedbank.playgrounds.dto.out;

import io.swedbank.playgrounds.enums.Equipment;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class PlaySiteDtoOut {

    private String name;
    private Integer utilization;
    private Integer visitors;
    private List<Equipment> equipmentList;
}
