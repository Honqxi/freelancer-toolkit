package com.joakim.freelancertoolkitbackend.service.Impl;

import com.joakim.freelancertoolkitbackend.domain.User;
import com.joakim.freelancertoolkitbackend.repository.UserRepository;
import com.joakim.freelancertoolkitbackend.security.JwtService;
import com.joakim.freelancertoolkitbackend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public String register(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return jwtService.generateToken(user.getEmail());
    }

    @Override
    public String login(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return jwtService.generateToken(user.getEmail());
    }
}
