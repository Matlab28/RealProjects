package com.example.login.controller;

import com.example.login.dto.request.GuestRequestDto;
import com.example.login.dto.response.GuestResponseDto;
import com.example.login.exception.MyException;
import com.example.login.service.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/guest")
public class GuestController {
    private final GuestService service;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/create")
    public String create(@RequestBody GuestRequestDto dto) {
        return service.create(dto);
    }

    @GetMapping("/read")
    public List<GuestResponseDto> read() {
        return service.read();
    }

    @PutMapping("/update/P{id}")
    public String update(@PathVariable Long id, @RequestBody GuestRequestDto dto) throws MyException {
        return service.update(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) throws MyException {
        return service.delete(id);
    }

    @GetMapping("/min-age")
    public List<GuestResponseDto> findByMinAge(@RequestParam Integer minAge) throws MyException {
        return service.findByMinAge(minAge);
    }
}
