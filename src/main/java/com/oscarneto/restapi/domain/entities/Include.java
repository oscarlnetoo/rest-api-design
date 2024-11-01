package com.oscarneto.restapi.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Include {

    private String what;
    private String description;
}
