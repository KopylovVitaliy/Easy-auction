package ru.skypro.cweasyauction.dto;


import lombok.Getter;
import lombok.Setter;

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

    @Override
    public String toString() {
        return "BidderDTO{" +
                "bidderName='" + bidderName + '\'' +
                ", bidDate='" + bidDate + '\'' +
                '}';
    }
}
