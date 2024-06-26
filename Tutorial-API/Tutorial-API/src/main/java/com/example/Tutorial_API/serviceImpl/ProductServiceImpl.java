package com.example.Tutorial_API.serviceImpl;

import com.example.Tutorial_API.dao.ProductRepository;
import com.example.Tutorial_API.model.Product;
import com.example.Tutorial_API.pojo.ProductVO;
import com.example.Tutorial_API.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class ProductServiceImpl implements ProductService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductVO addProduct(ProductVO productVO) {
        logger.info("Inside addProduct method");
       Product objProduct =  new Product();

        UUID uuid = UUID.randomUUID();
        objProduct.setId(uuid);
        objProduct.setName(productVO.getName());
        objProduct.setBrand(productVO.getBrand());
        objProduct.setCategory(productVO.getCategory());
        objProduct.setDescription(productVO.getDescription());
        objProduct.setTags(productVO.getTags());
        productRepository.save(objProduct);
        logger.info("Exit addProduct method");
        return productVO;
    }

    @Override
    public List<ProductVO> getAllProducts() {
        logger.info("Inside getAllProducts method");
        List<Product> lstOfProduct =  productRepository.findAll();

        List<ProductVO> lstProduct = new ArrayList<>();
        for(Product product1 : lstOfProduct){
            ProductVO productVO = new ProductVO();

            productVO.setId(product1.getId());
            productVO.setName(product1.getName());
            productVO.setBrand(product1.getBrand());
            productVO.setCategory(product1.getCategory());
            productVO.setDescription(product1.getDescription());
            productVO.setTags(product1.getTags());
            productVO.setCreateDate(product1.getCreateDate());
            lstProduct.add(productVO);
        }
        logger.info("Exit getAllProducts method");
        return lstProduct;
    }

    @Override
    public List<ProductVO> getProductByCategory(String category) {
      logger.info("Inside getProductByCategory method");
      List<Product> listProduct = productRepository.findByCategory(category);
     List<ProductVO> productVOS = new ArrayList<ProductVO>();
      for(Product product : listProduct){
          ProductVO productVO = new ProductVO();

          productVO.setId(product.getId());
          productVO.setName(product.getName());
          productVO.setBrand(product.getBrand());
          productVO.setCategory(product.getCategory());
          productVO.setDescription(product.getDescription());
          productVO.setTags(product.getTags());
          productVO.setCreateDate(product.getCreateDate());

          productVOS.add(productVO);
      }
        logger.info("Exit getProductByCategory method");
        return productVOS;
    }
}
