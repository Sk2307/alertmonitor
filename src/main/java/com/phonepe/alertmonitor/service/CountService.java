package com.phonepe.alertmonitor.service;

import com.phonepe.alertmonitor.model.Alert;
import com.phonepe.alertmonitor.model.MicroServiceConfig;
import com.phonepe.alertmonitor.model.window.Count;

public interface CountService {
    void countWindowInit(Count count, Alert alert);
}
