package com.example.CarsInfo.Controller;

import com.example.CarsInfo.Entity.Category;
import com.example.CarsInfo.Service.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {

    @Autowired
    private CategoryServices categoryServices;

    @PostMapping("/savecategory")
    public  Category saveCategory(@RequestBody Category category){

        return categoryServices.saveCategory(category);
    }

    //GetallCategory

//    @GetMapping("/getAllcategory")
//    public List<Category> getAllcategory(){
//
//        return categoryServices.getAllcategory();
//    }

    @GetMapping("/getAllCategoryPaged")
    public Page<Category> getAllCategoryPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "8") int size) {
        Pageable pageable = PageRequest.of(page, size);
        System.err.println(pageable);
        return categoryServices.getAllCategoryPaged(pageable);
    }


    @GetMapping("/getAllcategorybyId/{id}" )
    public Optional<Category> getAllcategorybyId(@PathVariable Long id){

        return categoryServices.getAllcategorybyId(id);
    }

    @PutMapping("/updateCategoryById/{id}")
    public Optional<Category> updateCategoryById(@PathVariable Long id, @RequestBody Category category){
        return categoryServices.updateCategoryById(id,category);

    }

   @DeleteMapping("/deleteCategoryById/{id}")
    public void deleteCategoryById (@PathVariable Long id){

        categoryServices.deleteCategoryById(id);
    }


}
