package com.pharmacy.PharmacyApi.controllers;

import com.pharmacy.PharmacyApi.infra.TokenData;
import com.pharmacy.PharmacyApi.infra.TokenService;
import com.pharmacy.PharmacyApi.user.AuthData;
import com.pharmacy.PharmacyApi.user.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody @Valid AuthData data){

        var token = new UsernamePasswordAuthenticationToken(data.username(), data.password());

        var auth = manager.authenticate(token);

        var tokenJWT = tokenService.GenerateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new TokenData(tokenJWT));
    }

}
