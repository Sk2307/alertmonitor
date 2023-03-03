package com.phonepe.alertmonitor.service;

import com.phonepe.alertmonitor.model.Alert;
import com.phonepe.alertmonitor.model.MicroServiceConfig;
import com.phonepe.alertmonitor.model.window.SlidingWindow;

public interface SlidingWindowService {

    void slidingWindowInit(SlidingWindow slidingWindow, Alert alert);
}
