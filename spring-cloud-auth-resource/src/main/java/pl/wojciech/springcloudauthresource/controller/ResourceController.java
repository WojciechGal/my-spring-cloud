package pl.wojciech.springcloudauthresource.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class ResourceController {

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    @GetMapping("/role")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public String role() {
        return "You're either user or admin";
    }
}
