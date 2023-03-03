package com.phonepe.alertmonitor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Alert {

    public String client;
    public String eventType;
    public List<DispatchStrategy> dispatchStrategyList;

}
