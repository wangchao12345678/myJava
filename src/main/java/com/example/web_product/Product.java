package com.example.web_product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int id;
    private int product_no;
    private String product_name;
    private String product_type;
    private int Status;
}
