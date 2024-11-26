package com.example.CarsInfo.Service;

import com.example.CarsInfo.Entity.Product;
import com.example.CarsInfo.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceIMPL implements  ProductServices{

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }


//    @Override
//    public List<Product> getAllProduct() {
//        return productRepo.findAll() ;
//    }


    @Override
    public Optional<Product> getproductById(Long id) {
        return productRepo.findById(id);
    }

    @Override
    public Optional<Product> updateProductById(Long id, Product product) {
        Optional<Product> find =productRepo.findById(id);
        if(find.isPresent()){
            Product getproduct =find.get();
            getproduct.setCarModel(product.getCarModel());
            productRepo.save(getproduct);
        }

        return find;
    }

    @Override
    public void deleteProductById(Long id) {
        productRepo.deleteById(id);
    }

    @Override
    public Page<Product> getAllProduct(Pageable pageable) {
        return productRepo.findAll(pageable);
    }


}
