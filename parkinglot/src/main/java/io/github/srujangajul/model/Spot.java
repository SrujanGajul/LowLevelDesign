package io.github.srujangajul.model;

import lombok.Data;

@Data
public class Spot {
    private final int spotId;
    private final VehicleType vehicleType;
    private boolean occupied;
    private int vehicleId;
    public enum VehicleType{
        TRUCK,
        BIKE,
        CAR,
    }

    Spot(int spotId, VehicleType vehicleType){
        this.spotId = spotId;
        this.vehicleType = vehicleType;
        this.occupied = false;
    }

    public boolean park(Vehicle vehicle){
        synchronized (this){
            try{
                if(!occupied && vehicle.getVehicleType() == this.vehicleType){
                    this.occupied = true;
                    this.vehicleId = vehicle.getVehicleId();
                    Thread.sleep(2000);
                    return true;
                }
            }
            catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    public void unpark(){
        occupied = false;
    }
}
