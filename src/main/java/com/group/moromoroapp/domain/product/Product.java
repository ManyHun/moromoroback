package com.group.moromoroapp.domain.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.group.moromoroapp.domain.cart.Cart;
import lombok.*;
import org.hibernate.sql.Update;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter@Setter@ToString
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productid = null;

    @Column(length = 225)
    private String pr_name;

    @Column(length = 225)
    private String mainimage;

    @Column(length = 225)
    private String serveimage;

    private int price;

    private int stock;

    @Column(length = 15)
    private String category;

    private String explanation;

    private int star;

    private int totalsales;


    @JsonIgnore
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cart> carts = new ArrayList<>();

    public Product(String pr_name, String mainimage, String serveimage, int price, int stock, String category, String explanation, int star, int totalsales) {
        this.pr_name = pr_name;
        this.mainimage = mainimage;
        this.serveimage = serveimage;
        this.price = price;
        this.stock = stock;
        this.category = category;
        this.explanation = explanation;
        this.star = star;
        this.totalsales = totalsales;

    }

    public void updateProd(String pr_name, String mainimage, String serveimage, int price, int stock, String category, String explanation, int star, int totalsales) {

        this.pr_name = pr_name;
        this.mainimage = mainimage;
        this.serveimage = serveimage;
        this.price = price;
        this.stock = stock;
        this.category = category;
        this.explanation = explanation;
        this.star = star;
        this.totalsales = totalsales;
    }
}
