package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.MarcaRequestDto;
import com.pragma.powerup.application.dto.response.MarcaResponseDto;
import com.pragma.powerup.application.handler.IMarcaHandler;
import com.pragma.powerup.application.mapper.IMarcaRequestMapper;
import com.pragma.powerup.application.mapper.IMarcaResponseMapper;
import com.pragma.powerup.domain.api.IMarcaServicePort;
import com.pragma.powerup.domain.model.MarcaModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MarcaHandler implements IMarcaHandler {

    private final IMarcaServicePort marcaServicePort;
    private final IMarcaRequestMapper marcaRequestMapper;
    private final IMarcaResponseMapper marcaResponseMapper;

    @Override
    public void saveMarca(MarcaRequestDto marcaRequestDto) {
        MarcaModel marcaModel = marcaRequestMapper.toMarca(marcaRequestDto);
        marcaServicePort.saveMarca(marcaModel);
    }

    @Override
    public List<MarcaResponseDto> getAllMarcas() {
        return marcaResponseMapper.toMarcaResponseDtoList(marcaServicePort.getAllMarcas());
    }
}
