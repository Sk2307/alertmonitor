package com.phonepe.alertmonitor.service;

import com.phonepe.alertmonitor.model.Alert;
import com.phonepe.alertmonitor.model.DispatchStrategy;
import com.phonepe.alertmonitor.model.WindowType;
import com.phonepe.alertmonitor.model.window.Count;
import com.phonepe.alertmonitor.model.window.SlidingWindow;
import com.phonepe.alertmonitor.model.window.TumblingWindow;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MonitoringServiceImpl implements MonitoringService{

    private AlertingService alertingService;

    @Autowired
    public MonitoringServiceImpl(AlertingService alertingService) {
        this.alertingService = alertingService;
    }

    @Override
    public void monitorTumblingWindow(Alert alert, TumblingWindow tumblingWindow, Boolean exception) {
        log.info("Monitoring Service: Client {} {} {} {}", alert.getClient(), alert.getEventType(), WindowType.TUMBLING_WINDOW , "start");
        if (exception) {
            log.info("Client {} {} {}", alert.getClient(), alert.getEventType(), "threshold breached");
            for (DispatchStrategy strategy: alert.getDispatchStrategyList()) {
                switch (strategy.getType()){
                    case ("CONSOLE"):
                        alertingService.consoleNotification(strategy);
                    case ("EMAIL"):
                        alertingService.emailNotification(strategy);
                }
            }
        }
        log.info("Monitoring Service: Client {} {} {} {}", alert.getClient(), alert.getEventType(), WindowType.TUMBLING_WINDOW , "end");
    }

    @Override
    public void monitorSlidingWindow(Alert alert, SlidingWindow slidingWindow, Boolean exception) {
        log.info("Monitoring Service: Client {} {} {} {}", alert.getClient(), alert.getEventType(), WindowType.TUMBLING_WINDOW , "start");
        if (exception) {
            log.info("Client {} {} {}", alert.getClient(), alert.getEventType(), "threshold breached");
            for (DispatchStrategy strategy: alert.getDispatchStrategyList()) {
                switch (strategy.getType()){
                    case ("CONSOLE"):
                        alertingService.consoleNotification(strategy);
                    case ("EMAIL"):
                        alertingService.emailNotification(strategy);
                }
            }
        }
        log.info("Monitoring Service: Client {} {} {} {}", alert.getClient(), alert.getEventType(), WindowType.TUMBLING_WINDOW , "end");
    }

    @Override
    public void monitorCount(Alert alert, Count countWindow, Boolean exception) {
        log.info("Monitoring Service: Client {} {} {} {}", alert.getClient(), alert.getEventType(), WindowType.TUMBLING_WINDOW , "start");
        if (exception) {
            log.info("Client {} {} {}", alert.getClient(), alert.getEventType(), "threshold breached");
            for (DispatchStrategy strategy: alert.getDispatchStrategyList()) {
                switch (strategy.getType()){
                    case ("CONSOLE"):
                        alertingService.consoleNotification(strategy);
                    case ("EMAIL"):
                        alertingService.emailNotification(strategy);
                }
            }
        }
        log.info("Monitoring Service: Client {} {} {} {}", alert.getClient(), alert.getEventType(), WindowType.TUMBLING_WINDOW , "end");
    }
}
