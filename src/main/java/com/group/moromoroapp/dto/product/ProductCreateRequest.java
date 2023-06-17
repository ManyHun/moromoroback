package com.group.moromoroapp.dto.product;

import lombok.Getter;

@Getter
public class ProductCreateRequest {
    private String category;
    private String explanation;
    private String mainimage;
    private String pr_name;
    private int price;
    private String serveimage;
    private int star;
    private int stock;
    private int totalsales;
}
