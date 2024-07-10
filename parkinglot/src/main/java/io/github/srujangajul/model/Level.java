package io.github.srujangajul.model;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

@Data
public class Level {
    private int levelId;
    private Map<Integer, Spot> spots = new HashMap<>();
    private boolean full;
    private Set<Spot> vacantSpots = new HashSet<>();

    public boolean park(int spotId, Vehicle vehicle){
        Spot spot = spots.get(spotId);
        return spot.park(vehicle);
    }

    public List<Integer> vacantSpots(){
        return vacantSpots.stream().map(Spot::getSpotId).collect(Collectors.toList());
    }
    public void unpark(int spotId){
        Spot spot = spots.get(spotId);
        vacantSpots.add(spot);
        spot.unpark();
    }

}
