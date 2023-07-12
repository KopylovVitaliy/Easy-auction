package ru.skypro.cweasyauction.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BidderDTO {
    private Integer id;
    private String bidderName;
    private String bidDate;

    public BidderDTO(Integer id,String bidderName, String bidDate) {
        this.id = id;
        this.bidderName = bidderName;
        this.bidDate = bidDate;

    }
    public BidderDTO() {
    }

    @Override
    public String toString() {
        return bidderName;
    }
}
