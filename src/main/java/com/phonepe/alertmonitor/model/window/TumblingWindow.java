package com.phonepe.alertmonitor.model.window;

import com.phonepe.alertmonitor.model.Threshold;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class TumblingWindow {
    int count;
    int windowSizeInSec;
    Threshold threshold;
}
