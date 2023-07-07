package ru.skypro.cweasyauction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.cweasyauction.pojo.Lot;

public interface LotRepository extends JpaRepository<Lot, Integer> {
}
