package pl.wojciech.springcloudclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Value("${user.role}")
    private String role;

    @GetMapping("/role")
    public Map<String, String> checkClientRole() {
        return Collections.singletonMap("role", role);
    }
}
