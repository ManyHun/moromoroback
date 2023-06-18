package com.group.moromoroapp.controller.cart;

import com.group.moromoroapp.domain.cart.Cart;
import com.group.moromoroapp.domain.user.Member;
import com.group.moromoroapp.domain.user.UserRepository;
import com.group.moromoroapp.dto.cart.CartCreateRequest;
import com.group.moromoroapp.service.cart.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://192.168.0.7:8080/")
public class CartController {
    private final CartService cartService;
    private final UserRepository userRepository;
    public CartController(CartService cartService, UserRepository userRepository){
        this.cartService = cartService;this.userRepository =userRepository;
    }



    @PostMapping("/cart")
    public void saveCart(@RequestBody CartCreateRequest request){
        cartService.cartSave(request);
    }


    @GetMapping("/cart")
    public List<Cart> getCart(@RequestParam long memId){
         Member member = userRepository.findById(memId);
        return cartService.getCart(member);
    }

    @DeleteMapping("/cart")
    public void cartDel (@RequestParam long cartId){
        cartService.cartDel(cartId);
    }

}
