package com.example.CarsInfo.Controller;

import com.example.CarsInfo.Entity.Product;
import com.example.CarsInfo.Service.CategoryServices;
import com.example.CarsInfo.Service.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

   @Autowired
    private ProductServices productServices;

   @PostMapping("/saveproduct")
   public Product saveProduct(@RequestBody Product product){

       return productServices.saveProduct(product);
   }


//   @GetMapping("/getAllProduct")
//   public List<Product> getAllProduct(){
//
//       return  productServices.getAllProduct();
//   }
@GetMapping("/getAllProductPaged")
public Page<Product> getAllProductPaged(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size) {
    Pageable pageable = PageRequest.of(page, size);
    return productServices.getAllProduct(pageable);
}

   @GetMapping("/getproductById/{id}")
   public Optional<Product> getproductById(@PathVariable Long id ){
        return productServices.getproductById(id);
   }

   @PutMapping("/updateProductById/{id}")
   public Optional<Product> updateProductById(@PathVariable Long id ,@RequestBody Product product){

       return productServices.updateProductById(id,product);
   }


   @DeleteMapping("/deleteProductById/{id}")
   public void deleteProductById (@PathVariable Long id){

       productServices.deleteProductById(id);

   }



}
