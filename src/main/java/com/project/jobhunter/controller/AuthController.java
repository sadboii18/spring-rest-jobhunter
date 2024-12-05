package com.project.jobhunter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RestController;

import com.project.jobhunter.domain.dto.LoginDTO;
import com.project.jobhunter.domain.dto.ResLoginDTO;
import com.project.jobhunter.util.SecurityUtil;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class AuthController {
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final SecurityUtil securityUtil;

    public AuthController(AuthenticationManagerBuilder authenticationManagerBuilder, SecurityUtil securityUtil) {
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.securityUtil = securityUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<ResLoginDTO> handleLoginData(@Valid @RequestBody LoginDTO loginDTO) {
        // Nap input gom username va password vao security
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                loginDTO.getUsername(), loginDTO.getPassword());

        // Xac thuc nguoi dung => can viet ham loadUserByUsername
        Authentication auth = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        String accessToken = this.securityUtil.CreateToken(auth);
        ResLoginDTO res = new ResLoginDTO();
        res.setAccessToken(accessToken);
        return ResponseEntity.ok().body(res);
    }

}