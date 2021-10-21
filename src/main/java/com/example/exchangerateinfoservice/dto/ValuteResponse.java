package com.example.exchangerateinfoservice.dto;

import com.example.exchangerateinfoservice.dto.valutes.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ValuteResponse {

    @JsonProperty("AUD")
    private AudValuteResponse aud;
    @JsonProperty("AMD")
    private AmdValuteResponse amd;
    @JsonProperty("AZN")
    private AznValuteResponse azn;
    @JsonProperty("BGN")
    private BgnValuteResponse bgn;
    @JsonProperty("BRL")
    private BrlValuteResponse brl;
    @JsonProperty("BYN")
    private BynValuteResponse byn;
    @JsonProperty("DKK")
    private DkkValuteResponse dkk;
    @JsonProperty("EUR")
    private EurValuteResponse eur;
    @JsonProperty("GBP")
    private GbpValuteResponse gbp;
    @JsonProperty("HKD")
    private HkdValuteResponse hkd;
    @JsonProperty("HUF")
    private HufValuteResponse huf;
    @JsonProperty("USD")
    private UsdValuteResponse usd;
}