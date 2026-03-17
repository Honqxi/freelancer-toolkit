package com.joakim.freelancertoolkitbackend.service;

import com.joakim.freelancertoolkitbackend.domain.User;

public interface AuthService {
    String register(User user);
    String login(String email, String password);
}
