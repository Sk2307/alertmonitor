package com.phonepe.alertmonitor.model.window;

import com.phonepe.alertmonitor.model.Threshold;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Count {
    int count;
    Threshold threshold;
}
