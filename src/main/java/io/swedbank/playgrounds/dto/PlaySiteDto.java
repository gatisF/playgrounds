package io.swedbank.playgrounds.dto;

import io.swedbank.playgrounds.enums.Equipment;
import io.swedbank.playgrounds.validation.ValidNumber;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class PlaySiteDto {

    @NotBlank(message = "Name is required")
    private String name;
    @ValidNumber
    private Integer totalEquipmentCount;
    @ValidNumber
    private Integer totalVisitors;
    private List<Equipment> equipmentList;
}
