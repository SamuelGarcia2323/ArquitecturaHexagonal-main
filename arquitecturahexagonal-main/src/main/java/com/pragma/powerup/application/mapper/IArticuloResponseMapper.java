package com.pragma.powerup.application.mapper;

import com.pragma.powerup.application.dto.response.ArticuloResponseDto;
import com.pragma.powerup.domain.model.ArticuloModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IArticuloResponseMapper {
    IArticuloResponseMapper INSTANCE = Mappers.getMapper(IArticuloResponseMapper.class);

    List<ArticuloResponseDto> toArticuloResponseDtoList(List<ArticuloModel> articuloModels);
}
