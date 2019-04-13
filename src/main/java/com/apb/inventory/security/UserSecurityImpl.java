package com.apb.inventory.security;

import com.apb.inventory.model.InventoryUser;
import com.apb.inventory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@Service
//TODO: UNDER CONSTRUCTION
public class UserSecurityImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        InventoryUser user = userRepository.findByUserName(username);

        org.springframework.security.core.userdetails.User.UserBuilder builder = null;
        if (user != null) {
            builder = User.withUsername(user.getUsername());
            builder.password(user.getPassword());
            builder.roles(user.getUsergroup());
            builder.accountLocked(false);
            builder.accountExpired(false);
            builder.credentialsExpired(false);
        }
        else
            throw new UsernameNotFoundException("User Not Found.");

        return builder.build();
    }
}
