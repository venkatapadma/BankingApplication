package com.finance.banking_app.controller;

import com.finance.banking_app.dto.LoginRequest;
import com.finance.banking_app.dto.SignUpRequest;
import com.finance.banking_app.entity.RoleType;
import com.finance.banking_app.entity.User;
import com.finance.banking_app.repository.UserRepository;
import com.finance.banking_app.util.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, UserRepository userRepository, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody @Valid SignUpRequest request) {
        if (userRepository.findByUsername(request.userName()).isPresent()) {
            return ResponseEntity.badRequest().body("Username is already exists");
        }
        User user = new User();
        user.setUsername(request.userName());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setRoles(Set.of(RoleType.ROLE_USER));
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully " + user.getId());
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.userName(), request.password())
        );

        UserDetails user = (UserDetails) authentication.getPrincipal();
        return new ResponseEntity<>(jwtUtil.generateJwtToken(user), HttpStatus.OK);
    }
}
