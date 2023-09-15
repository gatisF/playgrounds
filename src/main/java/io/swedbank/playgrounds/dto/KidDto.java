package io.swedbank.playgrounds.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class KidDto {

    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Age is required")
    private Integer age;
    @NotBlank(message = "Ticket number is required")
    private Long ticketNumber;
    @NotBlank(message = "Play site name is required")
    private String playSiteName;
}
