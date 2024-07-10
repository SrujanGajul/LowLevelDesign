package io.github.srujangajul.model;

import lombok.Data;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class ParkingLot {
    private int id;
    private boolean isFull;
    private Map<Integer, Level> levels = new HashMap<>();

    ParkingLot(List<Level> levels){
        for(Level level: levels){
            this.levels.put(level.getLevelId(), level);
        }
    }

    public boolean park(int levelId, int spotId, Vehicle vehicle){
        Level level = levels.get(levelId);
        return level.park(spotId, vehicle);
    }

    public void unpark(int levelId, int spotId){
        Level level = levels.get(levelId);
        level.unpark(spotId);
    }

    public Map<Integer, List<Integer>> vacantSpots(){
        return levels.values().stream()
                .collect(Collectors.groupingBy(
                        Level::getLevelId,
                        Collectors.flatMapping(
                                level -> level.getVacantSpots().stream().map(Spot::getSpotId),
                                Collectors.toList()
                        )
                ));
    }
}
