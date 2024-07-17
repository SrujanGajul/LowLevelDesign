package io.github.srujangajul.tcs.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrafficSignal {
    private int signalId;
    private Signal signal;
    private int redSignalTime;
    private int greenSignalTime;
    private int yellowSignalTime;
}
