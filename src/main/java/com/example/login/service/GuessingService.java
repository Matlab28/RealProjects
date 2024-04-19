package com.example.login.service;

import com.example.login.dto.regular.GuessingDto;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class GuessingService {
    private final Random random = new Random();

    public String guess(GuessingDto dto) {
        int anInt = random.nextInt(1, 20);
        JSONObject result = new JSONObject();

        if (dto.getNumber() == anInt) {
            result.put("message", "Your guess " + dto.getNumber() + ", random number: " + anInt + ". Congratulations, you guessed right!");
            result.put("success", true);
        } else {
            result.put("message", "Your guess " + dto.getNumber() + ", random number: " + anInt + ". Unfortunately, you guessed wrong...");
            result.put("success", false);
        }

        return result.toString();
    }
}
