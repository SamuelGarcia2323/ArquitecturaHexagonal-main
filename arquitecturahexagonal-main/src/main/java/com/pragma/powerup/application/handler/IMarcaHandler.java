package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.request.MarcaRequestDto;
import com.pragma.powerup.application.dto.response.MarcaResponseDto;

import java.util.List;

public interface IMarcaHandler {
    void saveMarca(MarcaRequestDto marcaRequestDto);
    List<MarcaResponseDto> getAllMarcas();
}
