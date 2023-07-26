package com.flora.backend.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/auth")
public class SecurityController {
    @GetMapping("/customer")
    public String HelloCustomer() {
        return "helloCustomer";
    }
    @GetMapping("/moderator/product")
    public String HelloModeratorProduct() {
        return "helloModeratorProduct";
    }
    @GetMapping("/moderator/blog")
    public String HelloModeratorBlog() {
        return "helloModeratorBlog";
    }
    @GetMapping("/admin")
    public String HelloAdmin() {
        return "helloAdmin";
    }
}
