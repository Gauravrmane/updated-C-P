package com.example.CarsInfo.Service;

import com.example.CarsInfo.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductServices {

    Product saveProduct(Product product);

    //List<Product> getAllProduct();
    

    Optional<Product> getproductById(Long id);

    Optional<Product> updateProductById(Long id, Product product);

    void deleteProductById(Long id);

    Page<Product> getAllProduct(Pageable pageable);
}
