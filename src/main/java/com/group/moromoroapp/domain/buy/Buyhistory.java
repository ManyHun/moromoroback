package com.group.moromoroapp.domain.buy;

import com.group.moromoroapp.domain.product.Product;
import com.group.moromoroapp.domain.user.Member;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter@Setter@ToString@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Buyhistory {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long buyhistoryid;

    @Column
    private String payoption;

    @Column
    private int shipping;

    @Column
    private String bu_postnumber;

    @Column
    private String adress;

    @Column
    private String note;

    @Column
    private LocalDate bu_date = LocalDate.now();

    @Column
    private LocalTime bu_time =LocalTime.now();

    @ManyToOne
    @JoinColumn(name = "product_productid")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "member_member_id")
    private Member member;

    @Column
    private String password;

    @Column
    private String phonnum;


    public Buyhistory(String payoption, int shipping, String bu_postnumber, String adress, String note, Product product, Member member, String password, String phonnum) {
        this.payoption = payoption;
        this.shipping = shipping;
        this.bu_postnumber = bu_postnumber;
        this.adress = adress;
        this.note = note;
        this.product = product;
        this.member = member;
        this.password = password;
        this.phonnum = phonnum;
    }
}
