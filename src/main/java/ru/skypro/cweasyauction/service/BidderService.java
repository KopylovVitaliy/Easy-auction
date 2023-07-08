package ru.skypro.cweasyauction.service;

import ru.skypro.cweasyauction.dto.BidderDTO;

import java.util.List;

public interface BidderService {
    List<BidderDTO> addNewBid(List<BidderDTO> bidderDTOS, int id);
}
