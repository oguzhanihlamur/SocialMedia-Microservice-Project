package dev.antozy.controller;

import dev.antozy.dto.request.LoginRequestDTO;
import dev.antozy.dto.request.RegisterRequestDTO;
import dev.antozy.entity.Auth;
import dev.antozy.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static dev.antozy.config.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(AUTH_SERVICE)
public class AuthController {
    private final AuthService authService;

    @PostMapping(REGISTER)
    public ResponseEntity<Auth> register(@RequestBody RegisterRequestDTO dto) {
        if (!dto.getPassword().equals(dto.getRepassword()))
            throw new RuntimeException("Passwords do not match");
        return ResponseEntity.ok(authService.register(dto));
    }

    @PostMapping(LOGIN)
    public ResponseEntity<Boolean> login(@RequestBody LoginRequestDTO dto) {
        return ResponseEntity.ok(authService.login(dto));
    }
}
