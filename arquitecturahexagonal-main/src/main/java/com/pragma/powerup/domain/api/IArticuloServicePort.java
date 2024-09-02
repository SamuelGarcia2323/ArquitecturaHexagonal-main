package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.model.ArticuloModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IArticuloServicePort {
    void saveArticulo(ArticuloModel articuloModel);

    List<ArticuloModel> getAllArticulos();
    Page<ArticuloModel> getAllArticulosPaginated(Pageable pageable);
}
