package io.github.srujangajul.model;

import lombok.Data;

@Data
public class Vehicle {
    private int vehicleId;
    private Spot.VehicleType vehicleType;
}
