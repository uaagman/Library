package com.sami.library.service.impl;


import com.sami.library.domain.Authority;
import com.sami.library.domain.User;
import com.sami.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Transactional
@Component
public class Populate {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public Populate(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    private void init() {
        User user = new User();
        user.setFullName("Samjhana Dhami");
        user.setUsername("sami");
        user.setPassword(passwordEncoder.encode("sami"));
        user.setEnabled(true);

        Authority authority = new Authority();
        authority.setAuthority("USER");
        user.setAuthorities(Collections.singletonList(authority));

        userRepository.save(user);
    }

    @EventListener
    public void load(ContextRefreshedEvent event){
//        init();
    }
}
