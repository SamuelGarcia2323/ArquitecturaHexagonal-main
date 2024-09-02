package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.request.ArticuloRequestDto;
import com.pragma.powerup.application.dto.response.ArticuloResponseDto;

import java.util.List;

public interface IArticuloHandler {
    void saveArticulo(ArticuloRequestDto articuloRequestDto);
    List<ArticuloResponseDto> getAllArticulos();
}
