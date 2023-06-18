package com.group.moromoroapp.dto.buy;

import lombok.Getter;

@Getter
public class BuyCreateRequest {
    private String payoption;
    private int shipping;
    private String bu_postnumber;
    private String adress;
    private String note;
    private long product_productid;
    private long member_member_id;
    private String password;
    private String phonnum;
    private String name;
    private int ea;
}
