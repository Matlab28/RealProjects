package com.example.login.controller;


import com.example.login.dto.regular.GuessingDto;
import com.example.login.service.GuessingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class GuessingController {

    private final GuessingService service;

    @PostMapping("/guess")
    public String guess(@RequestBody GuessingDto dto) {
        return service.guess(dto);
    }



//    private final Random random = new Random();

//    @PostMapping("/guess")
//    public String guess(@RequestBody GuessingDto dto) {
//        int anInt = random.nextInt(1,20);
//        JSONObject result = new JSONObject();
//
//        if (dto.getNumber() == anInt) {
//            result.put("message", "Your guess " + dto.getNumber() + ", random number: " + anInt + ". Congratulations, you guessed right!");
//            result.put("success", true);
//        } else {
//            result.put("message", "Your guess " + dto.getNumber() + ", random number: " + anInt + ". Unfortunately, you guessed wrong...");
//            result.put("success", false);
//        }
//
//        return result.toString();
//    }
}
