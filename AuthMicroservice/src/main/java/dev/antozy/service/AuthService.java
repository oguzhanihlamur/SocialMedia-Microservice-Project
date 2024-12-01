package dev.antozy.service;

import dev.antozy.dto.request.CreateUserRequestDTO;
import dev.antozy.dto.request.LoginRequestDTO;
import dev.antozy.dto.request.RegisterRequestDTO;
import dev.antozy.entity.Auth;
import dev.antozy.manager.UserProfileManager;
import dev.antozy.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository repository;
    private final UserProfileManager userProfileManager;

    public Auth register(RegisterRequestDTO dto) {
        Auth auth = repository.save(Auth.builder()
                .userName(dto.getUserName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build());

        userProfileManager.createUserProfile(CreateUserRequestDTO.builder()
                .authId(auth.getId())
                .userName(auth.getUserName())
                .email(auth.getEmail())
                .build());

        return auth;
    }

    public Boolean login(LoginRequestDTO dto) {
        return repository.existsByUserNameAndPassword(dto.getUsername(), dto.getPassword());
    }
}
