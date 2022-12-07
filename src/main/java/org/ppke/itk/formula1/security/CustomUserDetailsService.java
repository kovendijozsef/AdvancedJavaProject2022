package org.ppke.itk.formula1.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ppke.itk.formula1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//      read user with password and role from DB
        var dbUser = userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with username %s"));

//      populate Spring security user with data from DB user
        return org.springframework.security.core.userdetails.User.builder()
                .username(username)
                .password(dbUser.getPassword())
                .authorities(dbUser.getRole())
                .build();
    }
}

