package com.example.carrentalsystem.service.security;

import com.example.carrentalsystem.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.carrentalsystem.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username);
        UserBuilder builder = null;

        if(user != null){
            builder = User.withUsername(username);
            builder.disabled(false);
            builder.password(user.getPassword());
            builder.authorities(new SimpleGrantedAuthority("ROLE_USER"));

        }else {
            throw new UsernameNotFoundException("User not found");
        }
        return builder.build();
    }

}