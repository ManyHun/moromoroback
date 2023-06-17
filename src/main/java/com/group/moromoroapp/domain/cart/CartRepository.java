package com.group.moromoroapp.domain.cart;

import com.group.moromoroapp.domain.user.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByMember(Member member);
     Cart findByCartid(long cartid);
}
