package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.model.MarcaModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMarcaServicePort {
    void saveMarca(MarcaModel marcaModel);

    List<MarcaModel> getAllMarcas();
    Page<MarcaModel> getAllMarcasPaginated(Pageable pageable);
}
