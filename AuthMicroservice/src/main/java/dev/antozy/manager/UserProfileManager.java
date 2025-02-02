package dev.antozy.manager;

import dev.antozy.dto.request.CreateUserRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static dev.antozy.config.RestApis.CREATE_USER;

@FeignClient(url = "http://service-loadbalancer-user:9099/dev/v1/user-profile", name = "userProfileManager")
public interface UserProfileManager {

    @PostMapping(CREATE_USER)
    ResponseEntity<Boolean> createUserProfile(@RequestBody CreateUserRequestDTO createUserRequestDTO);

}
