package ru.skypro.cweasyauction.service;

import org.springframework.stereotype.Service;
import ru.skypro.cweasyauction.dto.BidderDTO;
import ru.skypro.cweasyauction.pojo.Lot;
import ru.skypro.cweasyauction.pojo.LotStatus;
import ru.skypro.cweasyauction.repository.BidderRopository;
import ru.skypro.cweasyauction.repository.LotRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BidderServiceImpl implements BidderService {
    private final BidderRopository bidderRopository;
    private final BidderMapper bidderMapper;
    private final LotService lotService;
    LocalDateTime localDateTime = LocalDateTime.now();

    public BidderServiceImpl(BidderRopository bidderRopository, BidderMapper bidderMapper, LotService lotService) {
        this.bidderRopository = bidderRopository;
        this.bidderMapper = bidderMapper;
        this.lotService = lotService;
    }

    @Override
    public List<BidderDTO> addNewBid(List<BidderDTO> bidderDTOS, int id) {
        Lot lot = lotService.getLotById(id);
        if (lot.getStatus().equals(LotStatus.CREATED.getStatus()) || lot.getStatus().equals(LotStatus.STOPPED.getStatus())) {
            throw new RuntimeException();
        }
        Optional<BidderDTO> bidders = bidderDTOS.stream()
                .filter(bidderDTO -> bidderDTO.getBidderName().isEmpty())
                .findFirst();
        if (bidders.isPresent()) {
            throw new RuntimeException();
        }
        return bidderRopository.saveAll(
                        bidderDTOS.stream()
                                .map(bidderMapper::toEntity)
                                .peek(bid -> {
                                            bid.setLot(lot);
                                            bid.setBidDate(localDateTime.toString());
                                        }
                                )
                                .collect(Collectors.toList())
                )
                .stream()
                .map(bidderMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public String find(int id) {
        return bidderRopository.findFirstBidder(id).stream()
                .findFirst()
                .orElseThrow()
                .getBidderName();

    }

}
