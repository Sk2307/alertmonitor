package com.phonepe.alertmonitor.service;

import com.phonepe.alertmonitor.model.DispatchStrategy;

public interface AlertingService {

    void consoleNotification(DispatchStrategy dispatchStrategy);

    void emailNotification(DispatchStrategy dispatchStrategy);
}
