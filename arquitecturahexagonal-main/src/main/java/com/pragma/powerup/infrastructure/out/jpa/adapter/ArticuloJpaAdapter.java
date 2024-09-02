package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.domain.model.ArticuloModel;
import com.pragma.powerup.domain.spi.IArticuloPersistencePort;
import com.pragma.powerup.infrastructure.out.jpa.entity.ArticuloEntity;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IArticuloEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.IArticuloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@RequiredArgsConstructor
public class ArticuloJpaAdapter implements IArticuloPersistencePort {

    private final IArticuloRepository articuloRepository;
    private final IArticuloEntityMapper articuloEntityMapper;

    @Override
    public void saveArticulo(ArticuloModel articuloModel) {
        ArticuloEntity articuloEntity = articuloRepository.save(articuloEntityMapper.toEntity(articuloModel));
        articuloEntityMapper.toArticuloModel(articuloEntity);
    }

    @Override
    public List<ArticuloModel> getAllArticulos() {
        List<ArticuloEntity> entityList = articuloRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return articuloEntityMapper.toArticuloModelList(entityList);
    }

    @Override
    public Page<ArticuloModel> getAllArticulosPaginated(Pageable pageable) {
        Page<ArticuloEntity> entityPage = articuloRepository.findAll(pageable);
        return entityPage.map(articuloEntityMapper::toArticuloModel);
    }

    @Override
    public Page<ArticuloModel> getAllArticulosPaginatedAndSorted(Pageable pageable, boolean ascending) {
        Sort sort = ascending ? Sort.by("name").ascending() : Sort.by("name").descending();
        Pageable sortedPageable = pageable.withSort(sort);
        Page<ArticuloEntity> entityPage = articuloRepository.findAll(sortedPageable);
        return entityPage.map(articuloEntityMapper::toArticuloModel);
    }
}
