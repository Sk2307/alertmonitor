package com.phonepe.alertmonitor.service;

import com.phonepe.alertmonitor.model.Alert;
import com.phonepe.alertmonitor.model.window.Count;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountServiceImpl implements CountService{

    private MonitoringService monitoringService;

    @Autowired
    public CountServiceImpl(MonitoringService monitoringService) {
        this.monitoringService = monitoringService;
    }

    @Override
    public void countWindowInit(Count count, Alert alert) {
        monitoringService.monitorCount(alert, count, false);
        try{
            // Todo: Implement Sliding Window
            if (count.getCount() > count.getThreshold().getCount())
                throw new Exception();
        } catch (Exception e) {
            monitoringService.monitorCount(alert, count, true);
        }
    }
}
