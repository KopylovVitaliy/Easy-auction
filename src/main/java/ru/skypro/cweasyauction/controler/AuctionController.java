package ru.skypro.cweasyauction.controler;

import org.springframework.web.bind.annotation.*;
import ru.skypro.cweasyauction.dto.BidderDTO;
import ru.skypro.cweasyauction.dto.LotDTO;
import ru.skypro.cweasyauction.dto.LotFullInfoDTO;
import ru.skypro.cweasyauction.service.LotService;

import java.util.List;

@RestController
@RequestMapping("/lot")
public class AuctionController {
    private final LotService lotService;

    public AuctionController(LotService lotService) {
        this.lotService = lotService;
    }
    @GetMapping("/{id}/first")
    public BidderDTO firstBidderInfo(){
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
    public void startBiddingForLotId(){

    }
    @PostMapping("/{id}/bid")
    public BidderDTO sendBidForLot(){
        return null;
    }
    @PostMapping("/{id}/stop")
    public LotDTO stopBiddingForLotId(){
        return null;
    }

    @PostMapping
    public List<LotDTO> addNewLot(@RequestBody List<LotDTO>  lotDTOS){
        return lotService.addNewLot(lotDTOS);
    }
}
