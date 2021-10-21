package com.example.exchangerateinfoservice.repository;

import com.example.exchangerateinfoservice.model.CurrencyHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CurrencyHistoryRepository extends JpaRepository<CurrencyHistory, UUID> {

}