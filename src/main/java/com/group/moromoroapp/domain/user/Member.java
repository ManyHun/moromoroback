package com.group.moromoroapp.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.group.moromoroapp.domain.cart.Cart;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column
    private String meId;

    @Column
    private String meEmail;

    @Column
    private String mePassword;

    @Column
    private String meAddress1;

    @Column
    private String meAddress2;

    @Column
    private String mePhone;

    @Column
    private String meName;

    @Column
    private String mePostNumber;

    @Column
    private String meDivision;
    @JsonIgnore
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cart> carts = new ArrayList<>();

    public Long getMemberId() {
        return memberId;
    }

    public String getMeId() {
        return meId;
    }

    public void setMeId(String meId) {
        this.meId = meId;
    }

    public String getMeEmail() {
        return meEmail;
    }

    public void setMeEmail(String meEmail) {
        this.meEmail = meEmail;
    }

    public String getMePassword() {
        return mePassword;
    }

    public void setMePassword(String mePassword) {
        this.mePassword = mePassword;
    }

    public String getMeAddress1() {
        return meAddress1;
    }

    public void setMeAddress1(String meAddress1) {
        this.meAddress1 = meAddress1;
    }

    public String getMeAddress2() {
        return meAddress2;
    }

    public void setMeAddress2(String meAddress2) {
        this.meAddress2 = meAddress2;
    }

    public String getMePhone() {
        return mePhone;
    }

    public void setMePhone(String mePhone) {
        this.mePhone = mePhone;
    }

    public String getMeName() {
        return meName;
    }

    public void setMeName(String meName) {
        this.meName = meName;
    }

    public String getMePostNumber() {
        return mePostNumber;
    }

    public void setMePostNumber(String mePostNumber) {
        this.mePostNumber = mePostNumber;
    }

    public String getMeDivision() {
        return meDivision;
    }

    public void setMeDivision(String meDivision) {
        this.meDivision = meDivision;
    }

    public Member(String meId, String meEmail, String mePassword, String meAddress1, String meAddress2, String mePhone, String meName, String mePostNumber, String meDivision) {
        this.meId = meId;
        this.meEmail = meEmail;
        this.mePassword = mePassword;
        this.meAddress1 = meAddress1;
        this.meAddress2 = meAddress2;
        this.mePhone = mePhone;
        this.meName = meName;
        this.mePostNumber = mePostNumber;
        this.meDivision = meDivision;
    }

    public void updateName(String me_email,String me_password, String Me_address1, String Me_address2, String Me_phone, String Me_name, String Me_postnumber, String Me_division) {

        this.meEmail = me_email;
        this.mePassword = me_password;
        this.meAddress1 = Me_address1;
        this.meAddress2 = Me_address2;
        this.mePhone = Me_phone;
        this.meName = Me_name;
        this.mePostNumber = Me_postnumber;
        this.meDivision = Me_division;
    }

}