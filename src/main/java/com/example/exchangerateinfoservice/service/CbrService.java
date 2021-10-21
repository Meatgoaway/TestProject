package com.example.exchangerateinfoservice.service;

import com.example.exchangerateinfoservice.model.CurrencyHistory;

import java.util.List;

public interface CbrService {

    List<CurrencyHistory> uploadCurrencyHistoryData();
}