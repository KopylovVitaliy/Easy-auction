package ru.skypro.cweasyauction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.skypro.cweasyauction.dto.BidderDTO;
import ru.skypro.cweasyauction.pojo.Bid;


import java.util.Optional;

@Repository
public interface BidderRopository extends JpaRepository<Bid, Integer> {

    @Query("SELECT new ru.skypro.cweasyauction.dto.BidderDTO(b.bidderName,b.bidDate) FROM Bid b WHERE b.lot.id=:id AND b.bidDate= (SELECT MIN(b2.bidDate) FROM Bid b2 WHERE b2.lot.id = b.lot.id)")
    Optional<BidderDTO> findFirstBidder(@Param("id") int id);
    @Query("SELECT new ru.skypro.cweasyauction.dto.BidderDTO(b.bidderName,b.bidDate) FROM Bid b WHERE b.lot.id=:id AND b.bidDate= (SELECT MAX(b2.bidDate) FROM Bid b2 WHERE b2.lot.id = b.lot.id)")
    Optional<BidderDTO> findLastBidder(@Param("id") int id);
    @Query("SELECT new ru.skypro.cweasyauction.dto.BidderDTO(b.bidderName,min(b.bidDate)) FROM Bid b WHERE b.lot.id=:id GROUP BY b.bidderName ORDER BY count(*) desc LIMIT 1")
    Optional<BidderDTO> findMaxBid(@Param("id") int id);

}

