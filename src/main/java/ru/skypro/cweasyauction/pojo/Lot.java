package ru.skypro.cweasyauction.pojo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Entity
@Getter
@Setter
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

    @Override
    public String toString() {
        return  id + status + title + description + startPrice + bidPrice + bidList ;
    }
}
