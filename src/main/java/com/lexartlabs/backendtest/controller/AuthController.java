package com.lexartlabs.backendtest.controller;

import com.lexartlabs.backendtest.domain.user.User;
import com.lexartlabs.backendtest.dto.JwtDto;
import com.lexartlabs.backendtest.dto.SignInDto;
import com.lexartlabs.backendtest.dto.SignUpDto;
import com.lexartlabs.backendtest.security.auth.TokenProvider;
import com.lexartlabs.backendtest.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AuthService service;
    @Autowired
    private TokenProvider tokenService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody SignUpDto data) {
        service.signUp(data);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtDto> signIn(@RequestBody SignInDto data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var authUser = authenticationManager.authenticate(usernamePassword);
        var accessToken = tokenService.generateAccessToken((User) authUser.getPrincipal());
        return ResponseEntity.ok(new JwtDto(accessToken));
    }
}