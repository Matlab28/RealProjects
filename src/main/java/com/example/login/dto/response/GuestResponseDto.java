package com.example.login.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class GuestResponseDto {
    private Long id;

    private String firstName, lastName;
    private Integer age;
}
