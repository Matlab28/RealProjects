package com.example.login.controller;

import com.example.login.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailController {
    private final EmailService service;

    @PostMapping("/send")
    public void sendEmail(@RequestParam String sub, @RequestParam String text) {
        service.sending(sub,text);
    }


//    @PostMapping("/send")
//    public void sendEmail(@RequestBody EmailRequestDto dto) {
//        service.sendEmail(dto);
//    }


}
