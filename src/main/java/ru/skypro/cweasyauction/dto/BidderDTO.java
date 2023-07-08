package ru.skypro.cweasyauction.dto;

import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import ru.skypro.cweasyauction.pojo.Lot;

import java.time.LocalDateTime;
@Getter
@Setter
public class BidderDTO {
    private String bidderName;


    public BidderDTO(String bidderName, Lot lot) {
        this.bidderName = bidderName;

    }

    public BidderDTO() {
    }
}
