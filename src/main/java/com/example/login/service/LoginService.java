package com.example.login.service;

import com.example.login.dto.regular.LoginDto;
import com.example.login.entity.LoginEntity;
import com.example.login.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class LoginService {
    private final ModelMapper modelMapper;
    private final LoginRepository repository;
    public String create(LoginDto dto) {
        LoginEntity loginEntity = mapDtoToEntity(dto);
        String emailRegex = "^[a-zA-Z0-9_]+(\\.[a-zA-Z0-9_]+)*@gmail\\.com$";
        String alphabetRegex = "[a-zA-Z]";
        String uppers = ".*[A-Z].*";
        String lowers = ".*[a-z].*";
        String numbers = ".*\\d+.*";

        if (!dto.getUsername().matches(alphabetRegex) && !dto.getUsername().matches(numbers)) {
            return "Username must contain numbers and letters...";
        }

        if (!dto.getEmail().matches(emailRegex)) {
            return "Invalid email address";
        }

        if (!dto.getPassword().matches(uppers)) {
            return "Password must contain at least an upper case";
        } else if (!dto.getPassword().matches(lowers)) {
            return "Password must contain at least a lower case";
        } else if (!dto.getPassword().matches(numbers)) {
            return "Password must contain at least a number";
        } else if (dto.getPassword().length() != 8) {
            return "Password length must be 8 characters";
        }

        if (!dto.getPassword().equals(dto.getPassConfirm())) {
            return "Please confirm password correctly";
        }

        repository.save(loginEntity);
        return "Thank you for your registration!";
    }

    public List<LoginDto> result() {
        List<LoginEntity> all = repository.findAll();

        return all
                .stream()
                .map(e -> modelMapper.map(e, LoginDto.class))
                .collect(Collectors.toList());
    }


    public LoginEntity mapDtoToEntity(LoginDto dto) {
        return modelMapper.map(dto, LoginEntity.class);
    }
}
