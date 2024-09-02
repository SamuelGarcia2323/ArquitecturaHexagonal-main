package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.domain.model.MarcaModel;
import com.pragma.powerup.domain.spi.IMarcaPersistencePort;
import com.pragma.powerup.infrastructure.out.jpa.entity.MarcaEntity;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IMarcaEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.IMarcaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RequiredArgsConstructor
public class MarcaJpaAdapter implements IMarcaPersistencePort {

    private final IMarcaRepository marcaRepository;
    private final IMarcaEntityMapper marcaEntityMapper;

    @Override
    public void saveMarca(MarcaModel marcaModel) {
        MarcaEntity marcaEntity = marcaRepository.save(marcaEntityMapper.toEntity(marcaModel));
        marcaEntityMapper.toMarcaModel(marcaEntity);
    }

    @Override
    public List<MarcaModel> getAllMarcas() {
        List<MarcaEntity> entityList = marcaRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return marcaEntityMapper.toMarcaModelList(entityList);
    }

    @Override
    public Page<MarcaModel> getAllMarcasPaginated(Pageable pageable) {
        Page<MarcaEntity> entityPage = marcaRepository.findAll(pageable);
        if (entityPage.isEmpty()) {
            throw new NoDataFoundException();
        }
        return entityPage.map(marcaEntityMapper::toMarcaModel);
    }
}
