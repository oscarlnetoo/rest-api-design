package com.oscarneto.restapi.presentation.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class OfferCreateRequestDTO {

    private Double discount;
    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date expires;
}
