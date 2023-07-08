package ru.skypro.cweasyauction.pojo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Lot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String status;
    private String title;
    private String description;
    private Integer startPrice;
    private Integer bidPrice;

    @OneToMany(mappedBy = "lot")
    private List<Bid> bidList;

    public Lot(String status
            , String title
            , String description
            , Integer startPrice
            , Integer bidPrice) {
        this.status = status;
        this.title = title;
        this.description = description;
        this.startPrice = startPrice;
        this.bidPrice = bidPrice;
    }

    public Lot() {

    }
}
