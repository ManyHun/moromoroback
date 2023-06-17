package com.group.moromoroapp.domain.user;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<Member, Long> {

//  Optional<User> findByName(String name);
    boolean existsByMeId(String userid);
    boolean existsByMeIdAndMePassword(String userid,String pw);


    List<Member> findByMeId(String userid);

    Optional<Member>  findByMemberId(long memberId);

    Member findById(long memId);




}
