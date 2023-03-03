package com.phonepe.alertmonitor;

import com.phonepe.alertmonitor.model.Alert;
import com.phonepe.alertmonitor.model.DispatchStrategy;
import com.phonepe.alertmonitor.model.Threshold;
import com.phonepe.alertmonitor.model.window.Count;
import com.phonepe.alertmonitor.model.window.SlidingWindow;
import com.phonepe.alertmonitor.model.window.TumblingWindow;
import com.phonepe.alertmonitor.service.CountService;
import com.phonepe.alertmonitor.service.SlidingWindowService;
import com.phonepe.alertmonitor.service.SlidingWindowServiceImpl;
import com.phonepe.alertmonitor.service.TumblingWindowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class AlertMonitorApplication {

	private static TumblingWindowService tumblingWindowService;
	private static SlidingWindowService slidingWindowService;
	private static CountService countService;

	public AlertMonitorApplication(TumblingWindowService tumblingWindowService, SlidingWindowService slidingWindowService
						, CountService countService) {
		this.tumblingWindowService = tumblingWindowService;
		this.slidingWindowService = slidingWindowService;
		this.countService = countService;
	}

	public static void main(String[] args) {
		SpringApplication.run(AlertMonitorApplication.class, args);

		TumblingWindow tumblingWindow = new TumblingWindow(10, 10, new Threshold(5));
		DispatchStrategy dispatchStrategyTumblingWindow = new DispatchStrategy("CONSOLE"
				, "issue in payment", null);
		List<DispatchStrategy> dispatchStrategyListTumblingWindow = new ArrayList<>();
		dispatchStrategyListTumblingWindow.add(dispatchStrategyTumblingWindow);
		Alert tumblingWindowAlert = new Alert("X", "PAYMENT_EXCEPTION", dispatchStrategyListTumblingWindow);

		tumblingWindowService.tumblingWindowInit(tumblingWindow, tumblingWindowAlert);

		SlidingWindow slidingWindow = new SlidingWindow(10, 10, new Threshold(5));
		DispatchStrategy dispatchStrategySlidingWindow = new DispatchStrategy("CONSOLE"
				, "issue in user service", null);
		List<DispatchStrategy> dispatchStrategyListSlidingWindow = new ArrayList<>();
		dispatchStrategyListSlidingWindow.add(dispatchStrategySlidingWindow);
		Alert slidingWindowAlert = new Alert("X", "USERSERVICE_EXCEPTION", dispatchStrategyListSlidingWindow);

		slidingWindowService.slidingWindowInit(slidingWindow, slidingWindowAlert);

		Count count = new Count(10, new Threshold(5));
		DispatchStrategy dispatchStrategyCount = new DispatchStrategy("EMAIL"
				, "issue in payment", null);
		List<DispatchStrategy> dispatchStrategyListCount = new ArrayList<>();
		dispatchStrategyListCount.add(dispatchStrategyCount);
		Alert countAlert = new Alert("Y", "PAYMENT_EXCEPTION", dispatchStrategyListCount);

		countService.countWindowInit(count, countAlert);

	}

}
