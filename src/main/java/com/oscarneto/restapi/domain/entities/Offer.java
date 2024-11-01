package com.oscarneto.restapi.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class Offer {

    private Double discount;
    private String description;
    private Date expires;
}
