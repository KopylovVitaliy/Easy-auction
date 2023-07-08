package ru.skypro.cweasyauction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.skypro.cweasyauction.pojo.Bid;

public interface BidderRopository extends JpaRepository<Bid, Integer> {


}
