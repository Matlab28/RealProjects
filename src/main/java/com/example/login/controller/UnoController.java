package com.example.login.controller;

import com.example.login.dto.request.UnoRequestDto;
import com.example.login.dto.response.UnoResponseDto;
import com.example.login.exception.MyException;
import com.example.login.service.Uno2Service;
import com.example.login.service.UnoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/uno")
public class UnoController {
    private final Uno2Service service;

    @PostMapping("/create")
    public String create(@RequestBody UnoRequestDto dto) {
        return service.create(dto);
    }



//    private final UnoService service;
//
//    @PostMapping("/create")
//    public String create(@RequestBody UnoRequestDto dto) {
//        return service.create(dto);
//    }
//
//    @GetMapping("/read")
//    public List<UnoResponseDto> read() {
//        return service.read();
//    }
//
//    @PostMapping("/add-logic")
//    public String addLogic(@RequestBody UnoRequestDto dto) throws MyException {
//        return service.addLogic(dto);
//    }
}
