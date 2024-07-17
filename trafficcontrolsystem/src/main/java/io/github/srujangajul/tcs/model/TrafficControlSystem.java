package io.github.srujangajul.tcs.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class TrafficControlSystem {
    private static final TrafficControlSystem trafficControlSystem = new TrafficControlSystem();
    Map<Integer, Road> roads = new HashMap<>();

    public void addRoad(Road road){
        roads.put(road.getRoadId(), road);
    }

    public void removeRoad(Road road){
        roads.remove(road.getRoadId());
    }

    public void controlTrafficSignal(){
        for(Road road: roads.values()){
            TrafficSignal signal = road.getTrafficSignal();
            // control traffic signal
        }
    }

    public void handleEmergency(int roadId){
        Road road = roads.get(roadId);
        road.getTrafficSignal().setSignal(Signal.GREEN);
        for(Road road1: roads.values()){
            if(!road.equals(road1)){
                // change the signal to RED.
            }
            //handle emergency case.
        }
    }

}
