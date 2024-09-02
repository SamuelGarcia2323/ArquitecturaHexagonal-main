package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IArticuloServicePort;
import com.pragma.powerup.domain.model.ArticuloModel;
import com.pragma.powerup.domain.spi.IArticuloPersistencePort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class ArticuloUseCase implements IArticuloServicePort {

    private final IArticuloPersistencePort articuloPersistencePort;

    public ArticuloUseCase(IArticuloPersistencePort articuloPersistencePort) {
        this.articuloPersistencePort = articuloPersistencePort;
    }

    @Override
    public void saveArticulo(ArticuloModel articuloModel) {
        articuloPersistencePort.saveArticulo(articuloModel);
    }

    @Override
    public List<ArticuloModel> getAllArticulos() {
        return articuloPersistencePort.getAllArticulos();
    }

    @Override
    public Page<ArticuloModel> getAllArticulosPaginated(Pageable pageable) {
        return articuloPersistencePort.getAllArticulosPaginated(pageable);
    }
}
