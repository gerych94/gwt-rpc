package com.demo.gxt_google_maps.shared;

import java.util.Date;

public class TitleTransit {
    private Date time;
    private String vehicleType;
    private String nameVehicleType;

    public TitleTransit(Date time, VehicleTypeTransit vehicleType){
        this.time = time;
        this.vehicleType = vehicleType.getNameVehicle();
        nameVehicleType = vehicleType.getNameVehicle().substring(0, 1).toUpperCase() + vehicleType.getNameVehicle().substring(1);
    }

    public Date getTime() {
        return time;
    }
    public String getVehicleType() {
        return vehicleType;
    }
    public String getNameVehicleType() {
        return nameVehicleType;
    }
}
