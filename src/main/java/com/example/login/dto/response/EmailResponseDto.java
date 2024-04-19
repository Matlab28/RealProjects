package com.example.login.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class EmailResponseDto {
    private Long id;
    private String subject, body, to, firstName;
}
