package com.example.exchangerateinfoservice.service;

import com.example.exchangerateinfoservice.model.CurrencyHistory;

import java.util.List;
import java.util.UUID;

public interface CurrencyHistoryService {

    List<CurrencyHistory> getAllCurrencyHistory();

    CurrencyHistory getCurrencyHistoryById(UUID currencyHistoryId);

    void deleteAllCurrencyHistory();

}