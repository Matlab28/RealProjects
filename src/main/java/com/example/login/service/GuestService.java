package com.example.login.service;

import com.example.login.dto.request.GuestRequestDto;
import com.example.login.dto.response.GuestResponseDto;
import com.example.login.entity.GuestEntity;
import com.example.login.exception.MyException;
import com.example.login.repository.GuestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class GuestService {
    private final ModelMapper modelMapper;
    private final GuestRepository repository;

    public String create(GuestRequestDto dto) {
        GuestEntity guestEntity = mapReqDtoToEntity(dto);

        if (dto.getAge() < 18) {
            return "They must be at least 18 year-old...";
        }
        repository.save(guestEntity);
        log.info("Guest list created successfully!");
        return "Guests added successfully!";
    }

    public List<GuestResponseDto> read() {
        List<GuestEntity> all = repository.findAll();
        log.info("Guest list responded successfully!");

        return all
                .stream()
                .map(m -> modelMapper.map(m, GuestResponseDto.class))
                .collect(Collectors.toList());
    }

    public String update(Long id, GuestRequestDto dto) throws MyException {
        GuestEntity guest = repository.findById(id)
                .orElseThrow(() -> new MyException("Guest not found by - " + id));
        log.info("Guest list updated successfully!");

        modelMapper.map(dto, guest);
        repository.save(guest);
        return id + " ID guest updated successfully!";
    }

    public String delete(Long id) throws MyException {
        GuestEntity guest = repository.findById(id)
                .orElseThrow(() -> new MyException("Guest not found by - " + id));
        log.info("Guest deleted successfully!");

        repository.delete(guest);
        return "Guest deleted successfully!";
    }

    public List<GuestResponseDto> findByMinAge(Integer minAge) throws MyException {
        List<GuestEntity> list = repository.findByMinAge(minAge)
                .orElseThrow(() -> new MyException("Guest not found age by - " + minAge));
        log.info("Guest found by minAge successfully!");

        return list
                .stream()
                .map(m -> modelMapper.map(m, GuestResponseDto.class))
                .collect(Collectors.toList());
    }

    public GuestEntity mapReqDtoToEntity(GuestRequestDto dto) {
        return modelMapper.map(dto, GuestEntity.class);
    }
}
