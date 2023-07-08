package ru.skypro.cweasyauction.service;

import org.springframework.stereotype.Component;
import ru.skypro.cweasyauction.dto.BidderDTO;
import ru.skypro.cweasyauction.pojo.Bid;

import java.time.LocalDateTime;

@Component
public class BidderMapper {
    LocalDateTime localDateTime = LocalDateTime.now();
    public BidderDTO toDTO(Bid bid){
        BidderDTO bidderDTO = new BidderDTO();
        bidderDTO.setBidderName(bid.getBidderName());
//        bidderDTO.setBidDate(localDateTime.toString());
//        bidderDTO.setLot(bid.getLot());
        return bidderDTO;
    }
    public Bid toEntity(BidderDTO bidderDTO){
        Bid bid = new Bid();
        bid.setBidderName(bidderDTO.getBidderName());
//        bid.setBidDate(bidderDTO.getBidDate());
//        bid.setLot(bidderDTO.getLot());
        return bid;
    }
}
