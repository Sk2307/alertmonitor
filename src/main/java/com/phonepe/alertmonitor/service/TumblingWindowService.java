package com.phonepe.alertmonitor.service;

import com.phonepe.alertmonitor.model.Alert;
import com.phonepe.alertmonitor.model.window.TumblingWindow;

public interface TumblingWindowService {
    void tumblingWindowInit(TumblingWindow tumblingWindow, Alert alert);
}
