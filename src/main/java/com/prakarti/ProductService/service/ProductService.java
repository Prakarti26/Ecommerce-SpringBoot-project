package com.prakarti.ProductService.service;

import com.prakarti.ProductService.entity.Product;
import com.prakarti.ProductService.model.ProductRequest;
import com.prakarti.ProductService.model.ProductResponse;

public interface ProductService {
     
    

    Long addProduct(ProductRequest productRequest);


    ProductResponse getProductById(long productId);
}
