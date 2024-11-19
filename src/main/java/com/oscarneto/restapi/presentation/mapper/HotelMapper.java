package com.oscarneto.restapi.presentation.mapper;

import com.oscarneto.restapi.domain.entity.Hotel;
import com.oscarneto.restapi.presentation.dto.response.HotelRetrieveResponseDTO;
import com.oscarneto.restapi.presentation.dto.response.PageResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface HotelMapper {

    HotelRetrieveResponseDTO toDTO(Hotel hotel);

    List<HotelRetrieveResponseDTO> toDTOList(List<Hotel> hotels);

    @Mapping(target = "pageNumber", source = "number")
    @Mapping(target = "pageSize", source = "size")
    PageResponseDTO<HotelRetrieveResponseDTO> toPageResponseDTO(Page<Hotel> hotels);
}
