package com.oscarneto.restapi.presentation.mapper;

import com.oscarneto.restapi.domain.entity.Vacation;
import com.oscarneto.restapi.presentation.dto.VacationCreateRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VacationMapper {
    Vacation toEntity(VacationCreateRequestDTO dto);
}
