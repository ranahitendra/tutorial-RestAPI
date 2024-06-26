package com.example.Tutorial_API.controller;


import com.example.Tutorial_API.pojo.ProductVO;
import com.example.Tutorial_API.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

@GetMapping("/v1/products")
    public List<ProductVO> getAllProducts(){
      return  productService.getAllProducts();
    }

@PostMapping("/v1/add")
    ProductVO addProduct(@RequestBody ProductVO productVO){
      productService.addProduct(productVO);
    return productVO;
}
@GetMapping("/v1/product/{category}")
public List<ProductVO> getProductByCategory(@PathVariable String category){
    List<ProductVO> productVO =  productService.getProductByCategory(category);
    return  productVO;
}

}
