package io.swedbank.playgrounds.dto;

import io.swedbank.playgrounds.domain.PlaySite;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class EquipmentDto {

    private Long id;
    private String name;
    private PlaySite playsite;
    private LocalDateTime dateCreated;
    private LocalDateTime lastUpdated;
}
