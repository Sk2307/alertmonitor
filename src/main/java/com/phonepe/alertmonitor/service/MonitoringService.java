package com.phonepe.alertmonitor.service;

import com.phonepe.alertmonitor.model.Alert;
import com.phonepe.alertmonitor.model.Threshold;
import com.phonepe.alertmonitor.model.WindowType;
import com.phonepe.alertmonitor.model.window.Count;
import com.phonepe.alertmonitor.model.window.SlidingWindow;
import com.phonepe.alertmonitor.model.window.TumblingWindow;

public interface MonitoringService {

    void monitorTumblingWindow(Alert alert, TumblingWindow tumblingWindow, Boolean exception);

    void monitorSlidingWindow(Alert alert, SlidingWindow slidingWindow, Boolean Exception);

    void monitorCount(Alert alert, Count countWindow, Boolean exception);

}
