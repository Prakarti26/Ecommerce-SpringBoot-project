package com.prakarti.ProductService.model;

import lombok.Data;

@Data
public class ProductRequest {

    private String Productname;
    private long price;
    private long quantity;
}
