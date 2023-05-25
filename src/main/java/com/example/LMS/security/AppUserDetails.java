package com.example.LMS.security;

import com.project.carworkshop.entity.Role;
import com.project.carworkshop.model.UserModel;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.stream.Collectors;


public class AppUserDetails extends User
{
    private UserModel userModel;
    public AppUserDetails(com.project.carworkshop.entity.User user)
    {
        super(user.getEmailId(),user.getPassword(),true,
                true,true,true,
                user.getRoles()
                        .stream()
                        .map((Role role) -> new SimpleGrantedAuthority(role.getRoleName()))
                        .collect(Collectors.toList()));

        this.userModel =  new UserModel(user);
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
}
