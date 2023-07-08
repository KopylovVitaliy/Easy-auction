package ru.skypro.cweasyauction.pojo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Locale;


@Getter
@Setter
@Entity
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String bidderName;
    private String bidDate;

    @ManyToOne
    private Lot lot;
    public Bid(String bidderName) {
        this.bidderName = bidderName;
        this.bidDate = bidDate;
    }

    public Bid() {

    }
}
