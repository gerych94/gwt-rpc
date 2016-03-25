package com.demo.gxt_google_maps.shared;

import java.io.Serializable;
import java.util.Date;

public class Transit implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
    private String firstName;
    private String lastName;
    private Date time;
    private Date timePosition;
    private Date timeServer;
    private Integer speed;
    private Integer height;
    private String model;
    private String number;
    private Integer distance;
    private PositionTransit position;
    private Integer degree;
    private VehicleTypeTransit vehicleType;
    private Boolean wifi;
    private Boolean checked1;
    private Boolean checked2;
    private TitleTransit title;
    private String state;

    public Transit(){}
    public Transit(Integer id, String firstName, String lastName, Date time, Date timePosition, Date timeServer, Integer speed, Integer height, String model, String number, Integer distance, PositionTransit position, Integer degree, Boolean wifi, Boolean checked1, Boolean checked2, VehicleTypeTransit vehicleType, String state) {
        super();

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.time = time;
        this.timePosition = timePosition;
        this.timeServer = timeServer;
        this.speed = speed;
        this.height = height;
        this.model = model;
        this.number = number;
        this.distance = distance;
        this.position = position;
        this.degree = degree;
        this.wifi = wifi;
        this.checked1 = checked1;
        this.checked2 = checked2;
        this.vehicleType = vehicleType;
        title = new TitleTransit(time, vehicleType);
        this.state = state;
    }
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getTimePosition() {
        return timePosition;
    }

    public void setTimePosition(Date timePosition) {
        this.timePosition = timePosition;
    }

    public Date getTimeServer() {
        return timeServer;
    }

    public void setTimeServer(Date timeServer) {
        this.timeServer = timeServer;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public PositionTransit getPosition() {
        return position;
    }

    public void setPosition(String Position) {
        this.position = position;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    public VehicleTypeTransit getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleTypeTransit vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Boolean isWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Boolean getChecked1() {
        return checked1;
    }

    public void setChecked1(Boolean checked1) {
        this.checked1 = checked1;
    }

    public Boolean getChecked2() {
        return checked2;
    }

    public void setChecked2(Boolean checked2) {
        this.checked2 = checked2;
    }

    public TitleTransit getTitle() {
        return title;
    }

    public void setTitle(TitleTransit title) {
        this.title = title;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
