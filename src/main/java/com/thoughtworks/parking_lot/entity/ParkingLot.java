package com.thoughtworks.parking_lot.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class ParkingLot {
    @Id
    @Column(unique = true)
    private String name;
    @NotNull
    private int capacity;
    @NotNull
    private String position;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "name")
    private List<ParkingOrder> parkingOrders;

    public ParkingLot() {
    }


    public ParkingLot(String name, @NotNull int capacity, @NotNull String position, @NotNull List<ParkingOrder> parkingOrders) {
        this.name = name;
        this.capacity = capacity;
        this.position = position;
        this.parkingOrders = parkingOrders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<ParkingOrder> getParkingOrders() {
        return parkingOrders;
    }

    public void setParkingOrders(List<ParkingOrder> parkingOrders) {
        this.parkingOrders = parkingOrders;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"capacity\":")
                .append(capacity);
        sb.append(",\"position\":\"")
                .append(position).append('\"');
        sb.append(",\"parkingOrders\":")
                .append(parkingOrders);
        sb.append('}');
        return sb.toString();
    }
}
