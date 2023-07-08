package ru.skypro.cweasyauction.service;

import org.springframework.stereotype.Service;
import ru.skypro.cweasyauction.dto.LotDTO;
import ru.skypro.cweasyauction.pojo.Lot;
import ru.skypro.cweasyauction.pojo.LotStatus;
import ru.skypro.cweasyauction.repository.LotRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LotServiceImpl implements LotService {
    private final LotRepository lotRepository;
    private final LotMapper lotMapper;

    public LotServiceImpl(LotRepository lotRepository, LotMapper lotMapper) {
        this.lotRepository = lotRepository;
        this.lotMapper = lotMapper;
    }

    @Override
    public List<LotDTO> addNewLot(List<LotDTO>  lotDTOS) {
        Optional<LotDTO> lots = lotDTOS.stream()
                .filter(lotDTO -> lotDTO.getBidPrice() < 1 || lotDTO.getStartPrice() < 1
                || lotDTO.getDescription().isEmpty() || lotDTO.getTitle().isEmpty())
                .findFirst();
        if (lots.isPresent()){
            throw new RuntimeException();
        }
        return lotRepository.saveAll(
                lotDTOS.stream()
                        .map(lotMapper::toEntity)
                        .collect(Collectors.toList())
        )
                .stream()
                .map(lotMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void startBiddingForLotId(int id) {
        Lot lot = lotRepository.findById(id)
                .orElseThrow();
        lot.setStatus(LotStatus.STARTED.getStatus());
        lotRepository.save(lot);
    }

    @Override
    public void stopBiddingForLotId(int id) {
        Lot lot = lotRepository.findById(id)
                .orElseThrow();
        lot.setStatus(LotStatus.STOPPED.getStatus());
        lotRepository.save(lot);
    }
    @Override
    public Lot getLotById(int id) {
        return lotRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }
    
}
