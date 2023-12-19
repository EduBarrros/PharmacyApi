package com.pharmacy.PharmacyApi.controllers;

import com.pharmacy.PharmacyApi.user.AuthData;
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

    @PostMapping
    public ResponseEntity<?> login(@RequestBody @Valid AuthData data){

        var token = new UsernamePasswordAuthenticationToken(data.username(), data.password());

        var auth = manager.authenticate(token);

        return ResponseEntity.ok().build();
    }

}
