package pl.wojciech.springcloudauthresource.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@Slf4j
public class ResourceController {

    @RequestMapping("/user")
    public Principal user(Principal user) {
        log.info("User name is {}", user.getName());
        return user;
    }

    @GetMapping("/role")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public String role() {
        return "You're either User or Admin";
    }
}
