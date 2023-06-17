package com.group.moromoroapp.dto.product;

import com.group.moromoroapp.domain.product.Product;

public class ProductResponse {
    private Long productid;
    private String pr_name;
    private String mainimage;
    private String serveimage;
    private int price;
    private int stock;
    private String category;
    private String explanation;
    private int star;
    private int totalsales;

    public ProductResponse(Product product) {
        this.productid = product.getProductid();
        this.pr_name = product.getPr_name();
        this.mainimage = product.getMainimage();
        this.serveimage = product.getServeimage();
        this.price = product.getPrice();
        this.stock = product.getStock();
        this.category = product.getCategory();
        this.explanation = product.getExplanation();
        this.star = product.getStar();
        this.totalsales = product.getTotalsales();
    }

    public Long getProductid() {
        return productid;
    }

    public String getPr_name() {
        return pr_name;
    }

    public String getMainimage() {
        return mainimage;
    }

    public String getServeimage() {
        return serveimage;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getCategory() {
        return category;
    }

    public String getExplanation() {
        return explanation;
    }

    public int getStar() {
        return star;
    }

    public int getTotalsales() {
        return totalsales;
    }
}
