package com.oscarneto.restapi.domain.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"location", "metadata"})
@JsonFilter("HotelFilter")
@Document("hotels")
public class Hotel {

    @Id
    private String id;

    private String uuid;
    private String type;
    private String name;
    private Date created;
    private Date modified;

    private String address1;

    private String airportCode;
    private int amenityMask;
    private String city;
    private int confidenceRating;
    private String countryCode;
    private String deepLink;
    private int highRate;
    private int hotelId;
    private boolean hotelInDestination;
    private int hotelRating;

    private Location location;

    private String locationDescription;
    private int lowRate;

    private Metadata metadata;

    private int postalCode;
    private int propertyCategory;
    private double proximityDistance;
    private String proximityUnit;
    private String rateCurrencyCode;
    private String shortDescription;
    private String stateProvinceCode;
    private String thumbNailUrl;
    private double tripAdvisorRating;
    private String tripAdvisorRatingUrl;

    private int version; // Represents the "__v" field
}
