package com.example.exchangerateinfoservice.service;

import com.example.exchangerateinfoservice.dto.CbrCurrencyResponse;
import com.example.exchangerateinfoservice.dto.valutes.EurValuteResponse;
import com.example.exchangerateinfoservice.dto.valutes.GbpValuteResponse;
import com.example.exchangerateinfoservice.dto.valutes.UsdValuteResponse;
import com.example.exchangerateinfoservice.model.CurrencyHistory;
import com.example.exchangerateinfoservice.repository.CurrencyHistoryRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CbrServiceImpl implements CbrService {

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();

    private final CurrencyHistoryRepository repository;

    @Value("${cbr.currency.url}")
    private String cbrSiteGetCurrencyUrl;

    @Autowired
    public CbrServiceImpl(CurrencyHistoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CurrencyHistory> uploadCurrencyHistoryData() {
        List<CurrencyHistory> response = new ArrayList<>();

        try {
            CbrCurrencyResponse cbrCurrency = getCbrCurrency();
            if (cbrCurrency == null || cbrCurrency.getValute() == null) {
                return response;
            }

            if (cbrCurrency.getValute().getUsd() != null) {
                UsdValuteResponse usd = cbrCurrency.getValute().getUsd();

                CurrencyHistory usdCurrencyHistory = CurrencyHistory.builder()
                        .name(usd.getName())
                        .charCode(usd.getCharCode())
                        .number(usd.getNumCode())
                        .denomination(usd.getNominal())
                        .amountInRubles(usd.getValue())
                        .previousAmountInRubles(usd.getPrevious())
                        .build();

                repository.save(usdCurrencyHistory);

                response.add(usdCurrencyHistory);
            }

            if (cbrCurrency.getValute().getEur() != null) {
                EurValuteResponse eur = cbrCurrency.getValute().getEur();

                CurrencyHistory eurCurrencyHistory = CurrencyHistory.builder()
                        .name(eur.getName())
                        .charCode(eur.getCharCode())
                        .number(eur.getNumCode())
                        .denomination(eur.getNominal())
                        .amountInRubles(eur.getValue())
                        .previousAmountInRubles(eur.getPrevious())
                        .build();

                repository.save(eurCurrencyHistory);

                response.add(eurCurrencyHistory);
            }

            if (cbrCurrency.getValute().getGbp() != null) {
                GbpValuteResponse gbp = cbrCurrency.getValute().getGbp();

                CurrencyHistory gbpCurrencyHistory = CurrencyHistory.builder()
                        .name(gbp.getName())
                        .charCode(gbp.getCharCode())
                        .number(gbp.getNumCode())
                        .denomination(gbp.getNominal())
                        .amountInRubles(gbp.getValue())
                        .previousAmountInRubles(gbp.getPrevious())
                        .build();

                repository.save(gbpCurrencyHistory);

                response.add(gbpCurrencyHistory);
            }
        } catch (Exception ex) {

        }

        return response;
    }

    private CbrCurrencyResponse getCbrCurrency() {
        CbrCurrencyResponse cbrResponse = null;

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            Request request = new Request.Builder()
                    .url(cbrSiteGetCurrencyUrl)
                    .get()
                    .build();

            Response requestResponse = client.newCall(request).execute();

            if (requestResponse.isSuccessful()) {
                cbrResponse = mapper.readValue(requestResponse.body().string(), CbrCurrencyResponse.class);
            }
        } catch (Exception ex) {
            return cbrResponse;
        }

        return cbrResponse;
    }

}