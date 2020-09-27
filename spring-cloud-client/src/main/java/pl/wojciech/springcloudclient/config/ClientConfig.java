package pl.wojciech.springcloudclient.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@Slf4j
public class ClientConfig {

    @Value("${user.role}")
    private String role;

    @PostConstruct
    public void printUserRole() {
        log.info("You are a {}", role);
    }
}
