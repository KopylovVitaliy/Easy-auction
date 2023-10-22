package ru.skypro.cweasyauction.service;

import ru.skypro.cweasyauction.dto.LotDTO;
import ru.skypro.cweasyauction.dto.LotFullInfoDTO;
import ru.skypro.cweasyauction.pojo.Lot;

import java.io.IOException;
import java.util.List;

public interface LotService {
    List<LotDTO> addNewLot(List<LotDTO>  lotDTO);
    void startBiddingForLotId(int id);
    void stopBiddingForLotId(int id);
    Lot getLotById(int id);
    LotFullInfoDTO getFullInfo(int id);
    void csvFile() throws IOException;
    String readTextFromFile(String fileName);
}
