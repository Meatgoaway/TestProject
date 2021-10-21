package com.example.exchangerateinfoservice.service;

import com.example.exchangerateinfoservice.model.CurrencyHistory;
import com.example.exchangerateinfoservice.repository.CurrencyHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CurrencyHistoryServiceImpl implements CurrencyHistoryService {

    private final CurrencyHistoryRepository repository;

    @Autowired
    public CurrencyHistoryServiceImpl(CurrencyHistoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CurrencyHistory> getAllCurrencyHistory() {
        return repository.findAll();
    }

    @Override
    public CurrencyHistory getCurrencyHistoryById(UUID currencyHistoryId) {
        return repository.findById(currencyHistoryId).orElse(null);
    }

    @Override
    public void deleteAllCurrencyHistory() {
        repository.deleteAll();
    }
}