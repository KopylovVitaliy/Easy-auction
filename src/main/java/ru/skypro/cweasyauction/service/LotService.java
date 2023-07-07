package ru.skypro.cweasyauction.service;

import ru.skypro.cweasyauction.dto.LotDTO;

import java.util.List;

public interface LotService {
    List<LotDTO> addNewLot(List<LotDTO>  lotDTO);
}
