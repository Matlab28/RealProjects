package com.example.login.dto.regular;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class LoginDto {
    private String username, email, password, passConfirm;
}
