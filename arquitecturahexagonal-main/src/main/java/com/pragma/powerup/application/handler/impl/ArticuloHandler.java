package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.ArticuloRequestDto;
import com.pragma.powerup.application.dto.response.ArticuloResponseDto;
import com.pragma.powerup.application.handler.IArticuloHandler;
import com.pragma.powerup.application.mapper.IArticuloRequestMapper;
import com.pragma.powerup.application.mapper.IArticuloResponseMapper;
import com.pragma.powerup.domain.api.IArticuloServicePort;
import com.pragma.powerup.domain.model.ArticuloModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ArticuloHandler implements IArticuloHandler {

    private final IArticuloServicePort articuloServicePort;
    private final IArticuloRequestMapper articuloRequestMapper;
    private final IArticuloResponseMapper articuloResponseMapper;

    @Override
    public void saveArticulo(ArticuloRequestDto articuloRequestDto) {
        ArticuloModel articuloModel = articuloRequestMapper.toArticulo(articuloRequestDto);
        articuloServicePort.saveArticulo(articuloModel);
    }

    @Override
    public List<ArticuloResponseDto> getAllArticulos() {
        return articuloResponseMapper.toArticuloResponseDtoList(articuloServicePort.getAllArticulos());
    }
}
