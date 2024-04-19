package com.example.login.service;

import com.example.login.dto.regular.UnoCards;
import com.example.login.dto.request.UnoRequestDto;
import com.example.login.dto.response.UnoResponseDto;
import com.example.login.entity.UnoEntity;
import com.example.login.exception.MyException;
import com.example.login.repository.UnoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UnoService {
    private final ModelMapper modelMapper;
    private final UnoRepository repository;
    Random random = new Random();

    public String create(UnoRequestDto dto) {
        UnoEntity uno = mapReqToEnt(dto);

        if (dto.getPlayers() != 2 && dto.getPlayers() != 4) {
            return "Only 2 or 4 people can play it...";
        }

        String space = ", ";
        String refunds = "";
        for (int i = 0; i < 7; i++) {
            int cards = random.nextInt(9);
            refunds += switch (cards) {
                case 0 -> UnoCards.RED.getValue() + space;
                case 1 -> UnoCards.GREEN.getValue() + space;
                case 2 -> UnoCards.YELLOW.getValue() + space;
                case 3 -> UnoCards.BLUE.getValue() + space;
                case 4 -> UnoCards.BLOCK.getValue() + space;
                case 5 -> UnoCards.FOUR_PLUS.getValue() + space;
                case 6 -> UnoCards.TWO_PLUS.getValue() + space;
                case 7 -> UnoCards.REVERSED.getValue() + space;
                case 8 -> UnoCards.CHANGE_COLOR.getValue() + space;
                default -> "Invalid output...";
            };

        }
        repository.save(uno);
        return refunds;
    }

    public String addLogic(UnoRequestDto dto) throws MyException {
        try {
            int loop = 1;
            String s = "";
            if (dto.getPlayers() == 2) {
                for (int i = 0; i < 2; i++) {
                    s += (loop++) + ") " + create(dto) + "\n";
                }
                return s;
            } else if (dto.getPlayers() == 4) {
                for (int i = 0; i < 4; i++) {
                    s += (loop++) + ") " + create(dto) + "\n";
                }
                return s;
            }
            return addLogic(dto);
        } catch (MyException e) {
            throw new MyException("Only 2 or 4 people can play it...");
        }
    }

    public List<UnoResponseDto> read() {
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
