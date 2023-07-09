package ru.skypro.cweasyauction.service;

import org.springframework.stereotype.Component;
import ru.skypro.cweasyauction.dto.LotDTO;
import ru.skypro.cweasyauction.dto.LotFullInfoDTO;
import ru.skypro.cweasyauction.pojo.Lot;
import ru.skypro.cweasyauction.repository.BidderRopository;

import static ru.skypro.cweasyauction.pojo.LotStatus.CREATED;

@Component
public class LotMapper {
    private final BidderRopository bidderRopository;

    public LotMapper(BidderRopository bidderRopository) {
        this.bidderRopository = bidderRopository;
    }

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
    public LotFullInfoDTO toFullInfo(Lot lot){
        LotFullInfoDTO lotFullInfoDTO = new LotFullInfoDTO();
        lotFullInfoDTO.setId(lot.getId());
        lotFullInfoDTO.setTitle(lot.getTitle());
        lotFullInfoDTO.setDescription(lot.getDescription());
        lotFullInfoDTO.setStartPrice(lot.getStartPrice());
        lotFullInfoDTO.setBidPrice(lot.getBidPrice());
        lotFullInfoDTO.setStatus(lot.getStatus());
        lotFullInfoDTO.setCurrentPrice(lot.getBidList().size() * lot.getBidPrice() + lot.getStartPrice());
        lotFullInfoDTO.setLastBid(bidderRopository.findLastBidder(lot.getId()).orElse(null));
        return lotFullInfoDTO;
    }
}
