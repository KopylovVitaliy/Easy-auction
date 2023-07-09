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
    private String bidDate;

    public BidderDTO(String bidderName, String bidDate) {
        this.bidderName = bidderName;
        this.bidDate = bidDate;

    }
    public BidderDTO() {
    }
}
