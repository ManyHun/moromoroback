package com.group.moromoroapp.domain.buy;

import com.group.moromoroapp.domain.user.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuyRepository extends JpaRepository<Buyhistory,Long> {
    List<Buyhistory> findByMember(Member member);
}
