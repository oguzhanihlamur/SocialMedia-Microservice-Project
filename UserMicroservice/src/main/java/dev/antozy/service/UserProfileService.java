package dev.antozy.service;

import dev.antozy.document.UserProfile;
import dev.antozy.dto.request.CreateUserRequestDTO;
import dev.antozy.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserProfileService {

    private final UserProfileRepository repository;

    private final CacheManager cacheManager;

    public void createUserProfile(CreateUserRequestDTO createUserRequestDTO) {

        repository.save(UserProfile.builder()
                .userName(createUserRequestDTO.getUserName())
                .authId(createUserRequestDTO.getAuthId())
                .email(createUserRequestDTO.getEmail())
                .build());

    }

    public List<UserProfile> getAll() {
        return repository.findAll();
    }

    @Cacheable("upper-case")
    public String upperName(String name) {
        String result = name.toUpperCase();
        try {
            Thread.sleep(3000L);
        } catch (Exception e) {

        }
        return result;
    }

    public void clearCache() {
        Objects.requireNonNull(cacheManager.getCache("upper-case")).clear();
    }
}
