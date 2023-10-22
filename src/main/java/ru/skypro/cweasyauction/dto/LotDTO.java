package ru.skypro.cweasyauction.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LotDTO {
    private String title;
    private String description;
    private Integer startPrice;
    private Integer bidPrice;

    public LotDTO(String status
            , String title
            , String description
            , Integer startPrice
            , Integer bidPrice) {
        this.title = title;
        this.description = description;
        this.startPrice = startPrice;
        this.bidPrice = bidPrice;
    }

    public LotDTO() {
    }
}
