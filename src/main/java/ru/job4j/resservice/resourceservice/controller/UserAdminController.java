package ru.job4j.resservice.resourceservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import ru.job4j.resservice.resourceservice.service.UserService;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class UserAdminController {

    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<Long> addUser(@AuthenticationPrincipal Jwt jwt) {
        String userName = jwt.getClaim("preferred_username");
        return ResponseEntity.status(HttpStatus.OK).body(userService.adduser(userName));
    }

    @DeleteMapping("/remove/{userId}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
