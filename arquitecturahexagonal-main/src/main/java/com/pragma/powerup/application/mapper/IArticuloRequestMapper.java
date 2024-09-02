package com.pragma.powerup.application.mapper;

import com.pragma.powerup.application.dto.request.ArticuloRequestDto;
import com.pragma.powerup.domain.model.ArticuloModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IArticuloRequestMapper {
    ArticuloModel toArticulo(ArticuloRequestDto articuloRequestDto);
}
