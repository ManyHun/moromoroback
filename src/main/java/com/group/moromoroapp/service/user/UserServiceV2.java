package com.group.moromoroapp.service.user;

import com.group.moromoroapp.domain.user.Member;
import com.group.moromoroapp.domain.user.UserRepository;
import com.group.moromoroapp.dto.user.request.UserCreateRequest;
import com.group.moromoroapp.dto.user.request.UserUpdateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceV2 {

  private final UserRepository userRepository;

  public UserServiceV2(UserRepository userRepository) {
    this.userRepository = userRepository;
  }



  @Transactional
  public void saveUser(UserCreateRequest request) {

    userRepository.save(new Member(request.getMe_id(),request.getMe_email(), request.getMe_password(), request.getMe_address1(), request.getMe_address2(),request.getMe_phone() ,request.getMe_name(), request.getMe_postnumber(), request.getMe_division()));
  }

  @Transactional(readOnly = true)
  public List<Member> userlist(){
    return userRepository.findAll();
  }

  @Transactional(readOnly = true)
  public boolean userIdCheck(String userid){
    return userRepository.existsByMeId(userid);
  }

  @Transactional(readOnly = true)
  public boolean userIdPwCheck(String userid,String pw){
    return userRepository.existsByMeIdAndMePassword(userid, pw);
  }

  @Transactional(readOnly = true)
  public List<Member> getMember(String userid){
    return userRepository.findByMeId(userid);



  }

  @Transactional
  public void updateUser(UserUpdateRequest request){
    Member member = userRepository.findByMemberId(request.getMemberId())
            .orElseThrow(IllegalArgumentException::new);
    member.updateName(request.getMeEmail(),request.getMePassword(),request.getMeAddress1(),request.getMeAddress2(),request.getMePhone(),request.getMeName(),request.getMePostNumber(),request.getMeDivision());
  }

  @Transactional
  public void userDelete(long meid){
    Member member = userRepository.findByMemberId(meid)
            .orElseThrow(IllegalArgumentException::new);

    userRepository.delete(member);

  }


}
