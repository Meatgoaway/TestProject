package com.example.exchangerateinfoservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CbrCurrencyResponse {

    @JsonProperty("Date")
    private Date date;
    @JsonProperty("PreviousDate")
    private Date previousDate;
    @JsonProperty("PreviousURL")
    private String previousURL;
    @JsonProperty("Timestamp")
    private Date timestamp;
    @JsonProperty("Valute")
    private ValuteResponse valute;
}