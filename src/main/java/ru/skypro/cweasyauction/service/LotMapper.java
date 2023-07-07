package ru.skypro.cweasyauction.service;

import org.springframework.stereotype.Component;
import ru.skypro.cweasyauction.dto.LotDTO;
import ru.skypro.cweasyauction.pojo.Lot;
import ru.skypro.cweasyauction.pojo.Status;

import static ru.skypro.cweasyauction.pojo.Status.CREATED;

@Component
public class LotMapper {
    public LotDTO toDto(Lot lot){
        LotDTO lotDTO = new LotDTO();
        lotDTO.setTitle(lot.getTitle());
        lotDTO.setDescription(lot.getDescription());
        lotDTO.setStartPrice(lot.getStartPrice());
        lotDTO.setBidPrice(lot.getBidPrice());
        return lotDTO;
    }

    public Lot toEntity(LotDTO lotDTO){
        Lot lot = new Lot();
        lot.setTitle(lotDTO.getTitle());
        lot.setDescription(lotDTO.getDescription());
        lot.setStartPrice(lotDTO.getStartPrice());
        lot.setBidPrice(lotDTO.getBidPrice());
        lot.setStatus(CREATED.getStatus());
        return lot;
    }
}
