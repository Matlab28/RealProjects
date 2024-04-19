package com.example.login.controller;

import com.example.login.dto.regular.LoginDto;
import com.example.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {
    private final LoginService service;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/create")
    public String create(@RequestBody LoginDto dto) {
        return service.create(dto);
    }

    @GetMapping("/read")
    public List<LoginDto> read() {
        return service.result();
    }

}
