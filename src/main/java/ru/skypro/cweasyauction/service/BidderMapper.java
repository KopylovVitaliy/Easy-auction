package ru.skypro.cweasyauction.service;

import org.springframework.stereotype.Component;
import ru.skypro.cweasyauction.dto.BidderDTO;
import ru.skypro.cweasyauction.pojo.Bid;
import ru.skypro.cweasyauction.pojo.Lot;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class BidderMapper {
    public BidderDTO toDTO(Bid bid){
        BidderDTO bidderDTO = new BidderDTO();
        bidderDTO.setBidderName(bid.getBidderName());
        bidderDTO.setBidDate(bid.getBidDate());

        return bidderDTO;
    }
    public Bid toEntity(BidderDTO bidderDTO){
        Bid bid = new Bid();
        bid.setBidderName(bidderDTO.getBidderName());
        bid.setBidDate(bid.getBidDate());
        return bid;
    }
}
