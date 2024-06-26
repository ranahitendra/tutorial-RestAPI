package com.example.Tutorial_API.service;

import com.example.Tutorial_API.model.Product;
import com.example.Tutorial_API.pojo.ProductVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ProductService {

    ProductVO addProduct(ProductVO productVO);

    List<ProductVO> getAllProducts();

    List<ProductVO> getProductByCategory(String category);
}
