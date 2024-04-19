package com.example.login.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class GuestRequestDto {
    private String firstName, lastName;
    private Integer age;
}
