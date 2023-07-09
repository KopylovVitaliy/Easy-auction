package ru.skypro.cweasyauction.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.skypro.cweasyauction.dto.LotDTO;
import ru.skypro.cweasyauction.dto.LotFullInfoDTO;
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
    Logger logger = LoggerFactory.getLogger(LotServiceImpl.class);


    public LotServiceImpl(LotRepository lotRepository, LotMapper lotMapper) {
        this.lotRepository = lotRepository;
        this.lotMapper = lotMapper;
    }

    @Override
    public List<LotDTO> addNewLot(List<LotDTO> lotDTOS) {
        logger.debug("Создание нового лота");
        Optional<LotDTO> lots = lotDTOS.stream()
                .filter(lotDTO -> lotDTO.getBidPrice() < 1 || lotDTO.getStartPrice() < 1
                        || lotDTO.getDescription().isEmpty() || lotDTO.getTitle().isEmpty())
                .findFirst();
        if (lots.isPresent()) {
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
        logger.debug("Начало приёма ставок на лот id=" + id);
        Lot lot = lotRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("ставка не найдена. id =" + id);
                    return new RuntimeException();
                });
        lot.setStatus(LotStatus.STARTED.getStatus());
        lotRepository.save(lot);
    }

    @Override
    public void stopBiddingForLotId(int id) {
        logger.debug("Окончание приёма ставок на лот id=" + id);
        Lot lot = lotRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("ставка не найдена. id =" + id);
                    return new RuntimeException();
                });
        lot.setStatus(LotStatus.STOPPED.getStatus());
        lotRepository.save(lot);
    }

    @Override
    public Lot getLotById(int id) {
        return lotRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("ставка не найдена. id =" + id);
                    return new RuntimeException();
                });
    }

    @Override
    public LotFullInfoDTO getFullInfo(int id) {
        return lotRepository.findById(id).stream()
                .map(lotMapper::toFullInfo)
                .findFirst()
                .orElseThrow(() -> {
                    logger.error("ставка не найдена. id =" + id);
                    return new RuntimeException();
                });
    }

}
