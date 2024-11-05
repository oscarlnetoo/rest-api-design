package com.oscarneto.restapi.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Document("vacations")
public class Vacation {

    @Id
    private String id;

    private String name;

    private String description;
    private String type;

    private List<Destination> destinations;
    private List<Include> includes;

    private Integer numberOfNights;
    private Double pricePP;
    private Offer offer;

    private Date validTill;
    private Boolean soldout = false;
    private List<String> pictures;
}
