package com.phonepe.alertmonitor.service;

import com.phonepe.alertmonitor.model.Alert;
import com.phonepe.alertmonitor.model.window.SlidingWindow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SlidingWindowServiceImpl implements SlidingWindowService{

    private MonitoringService monitoringService;

    @Autowired
    public SlidingWindowServiceImpl(MonitoringService monitoringService, AlertingService alertingService) {
        this.monitoringService = monitoringService;
    }
    @Override
    public void slidingWindowInit(SlidingWindow slidingWindow, Alert alert) {
        monitoringService.monitorSlidingWindow(alert, slidingWindow, false);
        try{
            // Todo: Implement Sliding Window
            if (slidingWindow.getCount() > slidingWindow.getThreshold().getCount())
                throw new Exception();
        } catch (Exception e) {
            monitoringService.monitorSlidingWindow(alert, slidingWindow, true);
        }
    }
}
