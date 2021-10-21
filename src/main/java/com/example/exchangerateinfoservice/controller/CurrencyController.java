package com.example.exchangerateinfoservice.controller;

import com.example.exchangerateinfoservice.model.CurrencyHistory;
import com.example.exchangerateinfoservice.service.CurrencyHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class CurrencyController {

    private final CurrencyHistoryService currencyHistoryService;

    @Autowired
    public CurrencyController(CurrencyHistoryService currencyHistoryService) {
        this.currencyHistoryService = currencyHistoryService;
    }

    @GetMapping(value = "/currency-histories")
    public ResponseEntity<List<CurrencyHistory>> getCurrencyHistories() {
        List<CurrencyHistory> currencyHistories = currencyHistoryService.getAllCurrencyHistory();

        return new ResponseEntity<>(currencyHistories, HttpStatus.OK);
    }

    @GetMapping(value = "/currency-histories/{currencyHistoryId}")
    public ResponseEntity<CurrencyHistory> getCurrencyHistoryById(@PathVariable("currencyHistoryId") UUID currencyHistoryId) {
        CurrencyHistory currencyHistory = currencyHistoryService.getCurrencyHistoryById(currencyHistoryId);

        return new ResponseEntity<>(currencyHistory, HttpStatus.OK);
    }

    @DeleteMapping(value = "/currency-histories")
    public ResponseEntity<CurrencyHistory> deleteAllCurrencyHistories() {
        currencyHistoryService.deleteAllCurrencyHistory();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}