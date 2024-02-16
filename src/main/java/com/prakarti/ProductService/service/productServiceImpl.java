package com.prakarti.ProductService.service;

import com.prakarti.ProductService.entity.Product;
import com.prakarti.ProductService.model.DBRespository;
import com.prakarti.ProductService.model.ProductRequest;
import com.prakarti.ProductService.model.ProductResponse;
import com.prakarti.ProductService.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class productServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Long addProduct(ProductRequest productRequest) {
        log.info("Product Request: Add product request is received {}", productRequest);
        Product product = Product.builder()
                                .productName(productRequest.getProductname())
                                .price(productRequest.getPrice())
                                .quantity(productRequest.getQuantity())
                                .build();
       productRepository.save(product);
       return product.getProductId();
    }

    @Override
    public ProductResponse getProductById(long productId) {
        log.info("Get product request is received");
        Product product = productRepository.findById(productId)
                         .orElseThrow(() -> new RuntimeException("Product not found"));
        ProductResponse productResponse = new ProductResponse();
        BeanUtils.copyProperties(product,productResponse);
        return productResponse;
    }


}
