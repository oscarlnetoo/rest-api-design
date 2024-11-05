package com.oscarneto.restapi.presentation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class VacationCreateRequestDTO {

    @NotEmpty
    private String name;

    @NotNull
    private String description;

    @Pattern(regexp = "resort|cruise")
    private String type;

    private List<DestinationCreateRequestDTO> destinations;
    private List<IncludeCreateRequestDTO> includes;

    @NotNull
    @Min(1)
    @Max(31)
    private Integer numberOfNights;

    private Double pricePP;

    private OfferCreateRequestDTO offer;

    @NotNull
    @FutureOrPresent
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date validTill;

    @NotNull
    private Boolean soldout;
    private List<String> pictures;
}
