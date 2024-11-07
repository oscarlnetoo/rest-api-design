package com.oscarneto.restapi.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DestinationCreateRequestDTO {

    private String city;
    private String country;
}
