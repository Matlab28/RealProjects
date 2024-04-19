package com.example.login.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class UnoRequestDto {
    private String username;
    private Integer players, score;
}
