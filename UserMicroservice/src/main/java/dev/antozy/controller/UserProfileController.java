package dev.antozy.controller;

import dev.antozy.document.UserProfile;
import dev.antozy.dto.request.CreateUserRequestDTO;
import dev.antozy.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static dev.antozy.config.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(USERPROFILE)
public class UserProfileController {
    private final UserProfileService userProfileService;

    @PostMapping(CREATE_USER)
    public ResponseEntity<Boolean> createUserProfile(@RequestBody CreateUserRequestDTO createUserRequestDTO) {
        userProfileService.createUserProfile(createUserRequestDTO);
        return ResponseEntity.ok(true);
    }

    @GetMapping(GET_ALL)
    public ResponseEntity<List<UserProfile>> getAll() {
        return ResponseEntity.ok(userProfileService.getAll());
    }

    @GetMapping("/upper-name")
    public ResponseEntity<String> upperName(String name) {
        return ResponseEntity.ok(userProfileService.upperName(name));
    }
}
