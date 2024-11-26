package com.example.CarsInfo.Repository;

import com.example.CarsInfo.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepo extends  JpaRepository<Product, Long>{
}
