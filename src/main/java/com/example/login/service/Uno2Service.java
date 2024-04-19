package com.example.login.service;

import com.example.login.dto.regular.UnoCards;
import com.example.login.dto.request.UnoRequestDto;
import com.example.login.dto.response.UnoResponseDto;
import com.example.login.entity.UnoEntity;
import com.example.login.repository.UnoRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@Getter
@Slf4j
@RequiredArgsConstructor
public class Uno2Service {
    private final ModelMapper modelMapper;
    private final UnoRepository repository;
    Random random = new Random();
    List<StringBuilder> check = new ArrayList<>();

    public String create(UnoRequestDto dto) {
        UnoEntity entity = mapReqToEnt(dto);
        int loop = 1;
        StringBuilder s = new StringBuilder();
        if (dto.getPlayers() == 2) {
            for (int i = 0; i < 2; i++) {
                s.append((loop++)).append(") ").append(getRandomCard()).append("\n");
            }
        } else if (dto.getPlayers() == 4) {
            for (int i = 0; i < 4; i++) {
                s.append((loop++)).append(") ").append(getRandomCard()).append("\n");
            }
        } else {
            return "Only 2 or 4 players can play...";
        }
        check.add(s);
        repository.save(entity);
        return s.toString();
    }

    private String getRandomCard() {
        int numbers = random.nextInt(10);
        int colors = random.nextInt(4);
        StringBuilder refund = new StringBuilder();
        String addColor = "";
        String space = ", ";

        for (int i = 0; i < 4; i++) {
            addColor = switch (colors) {
                case 0 -> UnoCards.RED.getValue();
                case 1 -> UnoCards.BLUE.getValue();
                case 2 -> UnoCards.GREEN.getValue();
                case 3 -> UnoCards.YELLOW.getValue();
                default -> throw new IllegalStateException("Invalid output...");
            };
        }

        for (int i = 0; i < 7; i++) {
            int cards = random.nextInt(9);
            refund.append(switch (cards) {
                case 0 -> UnoCards.RED.getValue() + " " + numbers + space;
                case 1 -> UnoCards.GREEN.getValue() + " " + numbers + space;
                case 2 -> UnoCards.YELLOW.getValue() + " " + numbers + space;
                case 3 -> UnoCards.BLUE.getValue() + " " + numbers + space;
                case 4 -> UnoCards.BLOCK.getValue() + " " + addColor + space;
                case 5 -> UnoCards.FOUR_PLUS.getValue() + space;
                case 6 -> UnoCards.TWO_PLUS.getValue() + " " + addColor + space;
                case 7 -> UnoCards.REVERSED.getValue() + " " + addColor + space;
                case 8 -> UnoCards.CHANGE_COLOR.getValue() + space;
                default -> throw new IllegalStateException("Invalid output...");
            });
        }
        return refund.toString();
    }

    private List<UnoResponseDto> read() {
        List<UnoEntity> all = repository.findAll();

        return all
                .stream()
                .map(m -> modelMapper.map(m, UnoResponseDto.class))
                .collect(Collectors.toList());
    }

    public UnoEntity mapReqToEnt(UnoRequestDto dto) {
        return modelMapper.map(dto, UnoEntity.class);
    }
}
