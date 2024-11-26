package com.example.CarsInfo.Service;

import com.example.CarsInfo.Entity.Category;
import com.example.CarsInfo.Entity.Product;
import com.example.CarsInfo.Repository.CategoryRepo;
import com.example.CarsInfo.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceIMPL implements CategoryServices {

    @Autowired
    private CategoryRepo categoryRepo;



    @Override
    public Category saveCategory(Category category) {
        return categoryRepo.save(category);
    }


//    @Override
//    public List<Category> getAllcategory() {
//        return categoryRepo.findAll();
//    }

    @Override
    public Optional<Category> getAllcategorybyId(Long id) {
        return categoryRepo.findById(id);
    }

    @Override
    public Optional<Category> updateCategoryById(Long id , Category category) {

        Optional<Category> find=categoryRepo.findById(id);
        if (find.isPresent()){

            Category getcategory=find.get();
            getcategory.setCompanyName(category.getCompanyName());
            categoryRepo.save(getcategory);
        }
        return find;
    }

    @Override
    public void  deleteCategoryById(Long id) {
        categoryRepo.deleteById(id);
    }


    //page
    @Override
    public Page<Category> getAllCategoryPaged(Pageable pageable) {
        return categoryRepo.findAll(pageable);
    }


}
