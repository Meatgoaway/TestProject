package com.example.exchangerateinfoservice.task;

import com.example.exchangerateinfoservice.model.CurrencyHistory;
import com.example.exchangerateinfoservice.service.CbrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ScheduledCbrTask {

    private final CbrService cbrService;

    @Autowired
    public ScheduledCbrTask(CbrService cbrService) {
        this.cbrService = cbrService;
    }

    @Scheduled(fixedDelayString = "${fixedDelay.in.milliseconds}")
    public void getCurrencyInfoFromCbr() {
        System.out.println("It's a good time to make a request to CBR: " + LocalDateTime.now());

        List<CurrencyHistory> currencyHistories = cbrService.uploadCurrencyHistoryData();

        if (!CollectionUtils.isEmpty(currencyHistories)) {
            System.out.println("Data from CBR is received");
        } else {
            System.out.println("No data from CBR is received");
        }
    }
}
