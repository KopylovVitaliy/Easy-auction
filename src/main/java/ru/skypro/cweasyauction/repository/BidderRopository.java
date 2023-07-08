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
    @Query(value = "SELECT min(id), bidder_name FROM Bid where lot_id = :id GROUP BY bidder_name LIMIT 1", nativeQuery = true)
    Optional<Bid> findFirstBidder(@Param("id") int id);
}

