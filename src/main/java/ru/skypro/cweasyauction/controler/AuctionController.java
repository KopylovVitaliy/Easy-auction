package ru.skypro.cweasyauction.controler;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.cweasyauction.dto.LotDTO;
import ru.skypro.cweasyauction.service.LotService;

import java.util.List;

@RestController
@RequestMapping("/lot")
public class AuctionController {
    private final LotService lotService;

    public AuctionController(LotService lotService) {
        this.lotService = lotService;
    }

    @PostMapping
    public List<LotDTO> addNewLot(@RequestBody List<LotDTO>  lotDTOS){
        return lotService.addNewLot(lotDTOS);
    }
}
