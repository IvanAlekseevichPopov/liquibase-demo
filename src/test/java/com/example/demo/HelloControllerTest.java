package com.example.demo;

import com.example.demo.controller.HelloController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerTest {
    @Autowired
    private HelloController controller;

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    public void controllerLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void helloControllerReturnsHello() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/hello",
                String.class)).contains("hello");
    }
}
