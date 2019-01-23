package com.example.edgeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FeignGreetingsClientApiGateway {
    private final GreetingsClient greetingsClient;

    @Autowired
    public FeignGreetingsClientApiGateway(GreetingsClient greetingsClient) {
        this.greetingsClient = greetingsClient;
    }

    @GetMapping("/feign/{name}")
    public Map<String, String> greet(@PathVariable String name) {
        return this.greetingsClient.greet(name);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/check-api/{name}")
    public Map<String, String> checkApi(@PathVariable String name,
                                        @RequestHeader(value = "X-CNJ-Name", required = false) Optional<String> cn) {
        String resolvedName = cn.orElse(name);
        return Collections.singletonMap("greeting", "Hello: " + resolvedName);
    }
}
