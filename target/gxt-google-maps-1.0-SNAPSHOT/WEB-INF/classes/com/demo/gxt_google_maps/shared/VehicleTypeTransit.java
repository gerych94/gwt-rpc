package com.demo.gxt_google_maps.shared;

public enum VehicleTypeTransit {
    BUS("bus"), CAR("car"), TRUCK("truck");

    private final String nameVehicle;

    VehicleTypeTransit(String nameVehicle) {
        this.nameVehicle = nameVehicle;
    }

    public String getNameVehicle() {
        return this.nameVehicle;
    }
}
