package com.group.moromoroapp.domain.cart;

import com.group.moromoroapp.domain.product.Product;
import com.group.moromoroapp.domain.user.Member;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZoneId;

@Getter@Setter@ToString@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartid;

    @Column
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "product_productid")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "member_member_id")
    private Member member;

    @Column
    private LocalDate ca_date = LocalDate.now(ZoneId.of("Asia/Seoul"));



    public Cart( int quantity,Product product, Member member) {

        this.quantity = quantity;
        this.product = product;
        this.member = member;

    }


}
