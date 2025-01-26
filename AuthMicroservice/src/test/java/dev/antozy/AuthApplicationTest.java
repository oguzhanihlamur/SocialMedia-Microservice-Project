//package dev.antozy;
//
//import dev.antozy.dto.request.LoginRequestDTO;
//import dev.antozy.dto.request.RegisterRequestDTO;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.annotation.DirtiesContext;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
////@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class AuthApplicationTest {
//
//    @Autowired
//    TestRestTemplate restTemplate;
//
//    private ResponseEntity<String> getResponse;
//
//    @Test
//    @DirtiesContext
////    @Order(1)
//    void shouldCreateANewAuth() {
//
//        RegisterRequestDTO registerRequestDTO = new RegisterRequestDTO("Antozy", "123", "123", "aantozy@gmail.com");
//
//        ResponseEntity<dev.antozy.entity.Auth> createResponse = restTemplate.postForEntity("/dev/v1/auth/register", registerRequestDTO, dev.antozy.entity.Auth.class);
//        assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
//
//        assertThat(createResponse.getBody()).isNotNull();
//
//        String userName = createResponse.getBody().getUserName();
//        String email = createResponse.getBody().getEmail();
//
//        assertThat(userName).isNotNull().isEqualTo("Antozy");
//        assertThat(email).isNotNull().isEqualTo("aantozy@gmail.com");
//    }
//
//    @Test
//    @DirtiesContext
////    @Order(2)
//    void shouldLogin() {
//        LoginRequestDTO loginRequestDTO = new LoginRequestDTO("Antozy", "123");
//
//        ResponseEntity<Boolean> loginResponse = restTemplate.postForEntity("/dev/v1/auth/login", loginRequestDTO, Boolean.class);
//        assertThat(loginResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(loginResponse.getBody()).isTrue();
//    }
//}
