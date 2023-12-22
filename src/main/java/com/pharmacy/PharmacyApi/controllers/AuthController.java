package com.pharmacy.PharmacyApi.controllers;

import com.pharmacy.PharmacyApi.infra.TokenData;
import com.pharmacy.PharmacyApi.infra.TokenService;
import com.pharmacy.PharmacyApi.remedy.Remedy;
import com.pharmacy.PharmacyApi.user.AuthData;
import com.pharmacy.PharmacyApi.user.RegisterData;
import com.pharmacy.PharmacyApi.user.User;
import com.pharmacy.PharmacyApi.user.UserRepository;
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
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterData data){

        var user = new User(data);

        user.encryptpassword();

        userRepository.save(user);

        return ResponseEntity.ok("Usuário cadastrado com sucesso.");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthData data){

        var token = new UsernamePasswordAuthenticationToken(data.username(), data.password());

        var auth = manager.authenticate(token);

        var tokenJWT = tokenService.GenerateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new TokenData(tokenJWT));
    }

}
