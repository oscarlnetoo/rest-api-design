package com.oscarneto.restapi.presentation.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class IncludeCreateRequestDTO {

    @Pattern(regexp = "flight|meals|cruise|hotel|rentalcar|excursions|misc")
    private String what;
    private String description;
}
