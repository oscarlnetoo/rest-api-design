package com.oscarneto.restapi.domain.entity;

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
