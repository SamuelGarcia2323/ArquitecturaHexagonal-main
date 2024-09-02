package com.pragma.powerup.application.mapper;

import com.pragma.powerup.application.dto.request.MarcaRequestDto;
import com.pragma.powerup.domain.model.MarcaModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IMarcaRequestMapper {
    MarcaModel toMarca(MarcaRequestDto marcaRequestDto);
}
