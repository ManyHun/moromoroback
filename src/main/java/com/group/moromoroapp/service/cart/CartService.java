package com.group.moromoroapp.service.cart;

import com.group.moromoroapp.domain.cart.Cart;
import com.group.moromoroapp.domain.cart.CartRepository;
import com.group.moromoroapp.domain.product.Product;
import com.group.moromoroapp.domain.user.Member;
import com.group.moromoroapp.dto.cart.CartCreateRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;
    public CartService(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }
    @PersistenceContext
    private EntityManager entityManager;
    public void cartSave(CartCreateRequest request) {
        Product product = entityManager.find(Product.class, request.getProduct_productid());
        Member member = entityManager.find(Member.class, request.getMember_member_id());
        Cart cart = new Cart(request.getQuantity(), product, member);
        cartRepository.save(cart);
    }

    public List<Cart> getCart(Member member){
        return cartRepository.findByMember(member);
    }

    public void cartDel(long cartId){
        Cart cart = cartRepository.findByCartid(cartId);

        cartRepository.delete(cart);
    }



}
