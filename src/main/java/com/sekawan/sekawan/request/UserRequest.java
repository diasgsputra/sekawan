package com.sekawan.sekawan.request;

import lombok.Data;

@Data
public class UserRequest {
  private String username;
  private String email;
  private String name;
  private String phone;
  private String address;
  private String gender;
  private String occupation;
  private String status;
  private String citizen;
}
