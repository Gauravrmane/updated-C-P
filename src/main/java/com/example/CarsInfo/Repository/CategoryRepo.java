package com.example.CarsInfo.Repository;

import com.example.CarsInfo.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepo extends  JpaRepository<Category, Long>{
}
