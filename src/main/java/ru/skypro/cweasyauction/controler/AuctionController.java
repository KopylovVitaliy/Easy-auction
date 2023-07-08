package ru.skypro.cweasyauction.controler;

import org.springframework.web.bind.annotation.*;
import ru.skypro.cweasyauction.dto.BidderDTO;
import ru.skypro.cweasyauction.dto.LotDTO;
import ru.skypro.cweasyauction.dto.LotFullInfoDTO;

import ru.skypro.cweasyauction.service.BidderMapper;
import ru.skypro.cweasyauction.service.BidderService;
import ru.skypro.cweasyauction.service.LotService;


import java.util.List;


@RestController
@RequestMapping("/lot")
public class AuctionController {
    private final LotService lotService;
    private final BidderService bidderService;



    public AuctionController(LotService lotService, BidderService bidderService) {
        this.lotService = lotService;
        this.bidderService = bidderService;

    }
    @GetMapping("/{id}/first")
    public BidderDTO firstBidderInfo(@PathVariable int id){
        return null;
    }
    @GetMapping("/{id}/frequent")
    public BidderDTO maxBidForLot(){
        return null;
    }
    @GetMapping("/{id}")
    public LotFullInfoDTO getFullInfo(){
        return null;
    }


    @PostMapping("/{id}/start")
    public void startBiddingForLotId(@PathVariable int id){
        lotService.startBiddingForLotId(id);
    }
    @PostMapping("/{id}/bid")
    public List<BidderDTO> sendBidForLot(@RequestBody List<BidderDTO> bidderDTOS, @PathVariable int id){
       return bidderService.addNewBid(bidderDTOS, id);
    }
    @PostMapping("/{id}/stop")
    public void stopBiddingForLotId(@PathVariable int id){
        lotService.stopBiddingForLotId(id);
    }

    @PostMapping
    public List<LotDTO> addNewLot(@RequestBody List<LotDTO>  lotDTOS){
        return lotService.addNewLot(lotDTOS);
    }
}
