package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IMarcaServicePort;
import com.pragma.powerup.domain.model.MarcaModel;
import com.pragma.powerup.domain.spi.IMarcaPersistencePort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class MarcaUseCase implements IMarcaServicePort {

    private final IMarcaPersistencePort marcaPersistencePort;

    public MarcaUseCase(IMarcaPersistencePort marcaPersistencePort) {
        this.marcaPersistencePort = marcaPersistencePort;
    }

    @Override
    public void saveMarca(MarcaModel marcaModel) {
        marcaPersistencePort.saveMarca(marcaModel);
    }

    @Override
    public List<MarcaModel> getAllMarcas() {
        return marcaPersistencePort.getAllMarcas();
    }

    @Override
    public Page<MarcaModel> getAllMarcasPaginated(Pageable pageable) {
        return marcaPersistencePort.getAllMarcasPaginated(pageable);
    }
}
