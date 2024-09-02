package com.pragma.powerup.application.mapper;

import com.pragma.powerup.application.dto.response.MarcaResponseDto;
import com.pragma.powerup.domain.model.MarcaModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IMarcaResponseMapper {
    IMarcaResponseMapper INSTANCE = Mappers.getMapper(IMarcaResponseMapper.class);

    List<MarcaResponseDto> toMarcaResponseDtoList(List<MarcaModel> marcaModels);
}
