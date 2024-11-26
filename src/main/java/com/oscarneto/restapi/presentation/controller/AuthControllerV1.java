package com.oscarneto.restapi.presentation.controller;

import com.oscarneto.restapi.common.utils.Constants;
import com.oscarneto.restapi.common.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constants.API_VERSION_V1 + "/auth")
public class AuthControllerV1 {

    private final AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        User user = (User) authentication.getPrincipal();

        return JwtUtil.generateToken(user.getUsername());
    }
}
