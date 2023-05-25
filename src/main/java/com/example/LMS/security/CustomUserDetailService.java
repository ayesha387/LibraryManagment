package com.example.LMS.security;

import com.project.carworkshop.entity.User;
import com.project.carworkshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService
{
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {

        AppUserDetails appUserDetails = null;

            User user = this.userRepository.findUserByEmailId(username);

            if(user == null)
            {
                throw new UsernameNotFoundException("User does not exist for emailId = " +username);
            }

            appUserDetails = new AppUserDetails(user);

        return appUserDetails;
    }
}
