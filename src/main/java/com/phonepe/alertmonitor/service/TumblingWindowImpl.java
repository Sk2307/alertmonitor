package com.phonepe.alertmonitor.service;

import com.phonepe.alertmonitor.model.Alert;
import com.phonepe.alertmonitor.model.window.TumblingWindow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TumblingWindowImpl implements TumblingWindowService{

    private MonitoringService monitoringService;

    @Autowired
    public TumblingWindowImpl(MonitoringService monitoringService, AlertingService alertingService) {
        this.monitoringService = monitoringService;
    }

    @Override
    public void tumblingWindowInit(TumblingWindow tumblingWindow, Alert alert) {
        monitoringService.monitorTumblingWindow(alert, tumblingWindow, false);
        try{
            // Todo: Implement Tumbling Window
            if (tumblingWindow.getCount() > tumblingWindow.getThreshold().getCount())
                throw new Exception();
        } catch (Exception e) {
            monitoringService.monitorTumblingWindow(alert, tumblingWindow, true);
        }
    }
}
