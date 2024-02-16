package com.prakarti.ProductService.controller;

import com.prakarti.ProductService.model.DBRespository;
import com.prakarti.ProductService.model.ProductRequest;
import com.prakarti.ProductService.model.ProductResponse;
import com.prakarti.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<DBRespository> save(@RequestBody ProductRequest productRequest){
        long productId =  productService.addProduct(productRequest);

    DBRespository dbRespository = DBRespository.builder()
                                                    .data(productId)
                                                    .message("Product Added")
                                                    .build();

    return new ResponseEntity<>(dbRespository, HttpStatus.CREATED);
    }


    @GetMapping("{/id}")
    public ResponseEntity<DBRespository> getProductById(@PathVariable("id") long productId){
        ProductResponse productResponse = productService.getProductById(productId);
        DBRespository dbRespository = DBRespository.builder()
                                                    .data(productResponse)
                                                    .message("Product Retrieved")
                                                    .build();
        return new ResponseEntity<>(dbRespository, HttpStatus.OK);
    }

}
