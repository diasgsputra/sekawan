package com.sekawan.sekawan.entity;

import com.sekawan.sekawan.request.UserRequest;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "sekawan")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String username;
  private String email;
  private String name;
  private String phone;
  private String address;
  private String gender;
  private String occupation;
  private String status;
  private String citizen;

  private String document;

  private String video;

  private String image;

  public User(UserRequest userRequest){
    this.setUsername(userRequest.getUsername());
    this.setEmail(userRequest.getEmail());
    this.setName(userRequest.getName());
    this.setPhone(userRequest.getPhone());
    this.setAddress(userRequest.getAddress());
    this.setGender(userRequest.getGender());
    this.setOccupation(userRequest.getOccupation());
    this.setStatus(userRequest.getStatus());
    this.setCitizen(userRequest.getCitizen());
  }

  public User(){
  }

}

