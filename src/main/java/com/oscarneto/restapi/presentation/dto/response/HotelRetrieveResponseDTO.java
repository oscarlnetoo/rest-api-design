package com.oscarneto.restapi.presentation.dto.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonFilter("HotelFilter")
public class HotelRetrieveResponseDTO {
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

    private LocationRetrieveResponseDTO location;

    private String locationDescription;
    private int lowRate;

    private MetadataRetrieveResponseDTO metadata;

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
}
