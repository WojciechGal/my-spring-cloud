package pl.wojciech.springcloudclient2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;

@RestController
@RequiredArgsConstructor
public class ClientController {

    private static final String ROLE_RESOURCE_URL = "http://localhost:9180/role";

    private final RestOperations restOperations;

    @GetMapping("/clientInfo")
    public String client() {
        return restOperations.getForObject(ROLE_RESOURCE_URL, String.class);
    }

    @GetMapping("/")
    public String notLogged() {
        return "You are not logged";
    }
}
