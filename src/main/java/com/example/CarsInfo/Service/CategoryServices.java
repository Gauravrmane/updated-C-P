package com.example.CarsInfo.Service;

import com.example.CarsInfo.Entity.Category;
import com.example.CarsInfo.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CategoryServices {
    Category saveCategory(Category category);



    //List<Category> getAllcategory();

    Optional<Category> getAllcategorybyId(Long id);

    Optional<Category> updateCategoryById(Long id, Category category);

    void deleteCategoryById(Long id);


    Page<Category> getAllCategoryPaged(Pageable pageable);
}
