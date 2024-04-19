package com.example.login.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class UnoResponseDto {
    private Long id;
    private String username;
    private Integer players, score;
}
