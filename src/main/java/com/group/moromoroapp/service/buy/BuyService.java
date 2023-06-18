package com.group.moromoroapp.service.buy;

import com.group.moromoroapp.domain.buy.Buyhistory;
import com.group.moromoroapp.domain.buy.BuyRepository;
import com.group.moromoroapp.domain.product.Product;
import com.group.moromoroapp.domain.product.ProductRepository;
import com.group.moromoroapp.domain.user.Member;
import com.group.moromoroapp.domain.user.UserRepository;
import com.group.moromoroapp.dto.buy.BuyCreateRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class BuyService {
    private final BuyRepository buyRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    public BuyService(BuyRepository buyRepository,UserRepository userRepository,ProductRepository productRepository){
        this.buyRepository =buyRepository;
        this.userRepository = userRepository;
        this.productRepository =productRepository;
    }

    @PersistenceContext
    private EntityManager entityManager;

    public void saveBuy(BuyCreateRequest request){
        Product product = entityManager.find(Product.class, request.getProduct_productid());
        Member member = entityManager.find(Member.class, request.getMember_member_id());
        Buyhistory buy = new Buyhistory(request.getPayoption(),request.getShipping(),request.getBu_postnumber(),request.getAdress(),request.getNote(),product,member, request.getPassword(),request.getPhonnum(),request.getName(),request.getEa());
        buyRepository.save(buy);
    }

    public List<Buyhistory> getBuy(long memId){
        Member member = userRepository.findById(memId);
        if (member.getMeDivision().equals("관리자")){
            return buyRepository.findAll();
        }

        return buyRepository.findByMember(member);
    }

}
