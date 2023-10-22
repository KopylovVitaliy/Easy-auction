package ru.skypro.cweasyauction.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LotCSVDTO {
    private Integer id;
    private String status;
    private String title;
    private Integer currentPrice;
    private BidderDTO lastBid;

    public LotCSVDTO(Integer id,
                     String title,
                     String status,
                     BidderDTO lastBid,
                     Integer currentPrice) {
        this.id = id;
        this.status = status;
        this.title = title;
        this.currentPrice = currentPrice;
        this.lastBid = lastBid;
    }

    public LotCSVDTO() {
    }

    @Override
    public String toString() {
        return id + "  " + "  " + title + "  " + status + "  " + lastBid + "  " + currentPrice;
    }
}
