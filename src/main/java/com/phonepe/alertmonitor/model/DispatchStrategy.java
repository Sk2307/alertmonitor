package com.phonepe.alertmonitor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DispatchStrategy {

    public String type;
    public String message;
    public String subject;

}
