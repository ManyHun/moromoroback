package com.group.moromoroapp.controller.user;

import com.group.moromoroapp.domain.user.Member;
import com.group.moromoroapp.dto.user.request.UserCreateRequest;
import com.group.moromoroapp.dto.user.request.UserUpdateRequest;
import com.group.moromoroapp.service.user.UserServiceV2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://192.168.0.7:8080/")
@CrossOrigin(origins = "*")
public class UserController {
  private final UserServiceV2 userService;

  public UserController(UserServiceV2 userService) {
    this.userService = userService;
  }

  @PostMapping("/user") // POST /member
  public void saveUser(@RequestBody UserCreateRequest request) {
    System.out.println(request.getMe_id());
    userService.saveUser(request);
  }

  @GetMapping("/userlist")
  public List<Member> userlist(){
    return userService.userlist();
  }


  @GetMapping("/idchech")
  public boolean userIdCheck(@RequestParam String userid){
    return userService.userIdCheck(userid);
  }

  @GetMapping("/login")
  public int login(@RequestParam String userid,String pw){
    boolean idCheck = userService.userIdCheck(userid);
    boolean pwCheck = userService.userIdPwCheck(userid, pw);
    System.out.println(idCheck);
    System.out.println(pwCheck);
    if (!idCheck){
      return 1;
    }else if (!pwCheck){
        return 2;
    }
   return 0;
  }

  @GetMapping("/loginSucceed")
  public List<Member> getMember(@RequestParam String userid){
    return userService.getMember(userid);
  }

  @PutMapping("/userUpdate")
  public void updateUser (@RequestBody UserUpdateRequest request){

    userService.updateUser(request);
  }

  @DeleteMapping("/userDelete")
  public void userDelete(@RequestParam Long meid) {
    userService.userDelete(meid);
  }


}
