package com.phonepe.alertmonitor.service;

import com.phonepe.alertmonitor.model.DispatchStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AlertingServiceImpl implements AlertingService {
    @Override
    public void consoleNotification(DispatchStrategy dispatchStrategy) {
        log.info("Alerting Service: Dispatching to {}", dispatchStrategy.getType());
        log.warn("Alert: {}", dispatchStrategy.getMessage());
    }

    @Override
    public void emailNotification(DispatchStrategy dispatchStrategy) {
        //ToDo: Implement Email Notification Service
        log.info("Alerting Service: Dispatching to {}", dispatchStrategy.getType());
    }
}
