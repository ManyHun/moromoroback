package com.group.moromoroapp.dto.cart;

import lombok.Getter;

@Getter
public class CartCreateRequest {
    private int quantity;
    private long product_productid;
    private long member_member_id;


}
