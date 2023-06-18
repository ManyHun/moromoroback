package com.group.moromoroapp.dto.user.request;

import lombok.Getter;

@Getter
public class UserUpdateRequest {
  private Long memberId;
  private String meId;
  private String meEmail;
  private String mePassword;
  private String meAddress1;
  private String meAddress2;
  private String mePhone;
  private String meName;
  private String mePostNumber;
  private String meDivision;

}
