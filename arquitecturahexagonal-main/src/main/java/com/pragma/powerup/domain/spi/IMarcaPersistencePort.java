package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.MarcaModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMarcaPersistencePort {

    void saveMarca(MarcaModel marcaModel);
    List<MarcaModel> getAllMarcas();
    Page<MarcaModel> getAllMarcasPaginated(Pageable pageable);
}
