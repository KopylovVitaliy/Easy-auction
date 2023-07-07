package ru.skypro.cweasyauction.pojo;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Locale;


@Getter
@Setter
public class Bid {
    LocalDateTime localDateTime = LocalDateTime.now();
    private String bidderName;
    private String bidDate;

    public Bid(String bidderName) {
        this.bidderName = bidderName;
        this.bidDate = String.valueOf(localDateTime);
    }
}
