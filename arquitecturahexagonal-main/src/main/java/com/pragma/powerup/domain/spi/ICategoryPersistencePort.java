package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.CategoryModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryPersistencePort {

    void saveCategory(CategoryModel categoryModel);

    List<CategoryModel> getAllCategories();

    Page<CategoryModel> getAllCategoriesPaginated(Pageable pageable);
}
