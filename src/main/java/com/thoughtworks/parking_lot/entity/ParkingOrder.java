package com.thoughtworks.parking_lot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class ParkingOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "name")
    @JsonIgnore
    private ParkingLot parkingLot;

    @NotNull
    private String number;
    @NotNull
    private String createTime;
    @NotNull
    private String endTime;
    @NotNull
    @Column(columnDefinition = "int default 1")
    private int state;


    public ParkingOrder(@NotNull ParkingLot parkingLot, @NotNull String number, @NotNull String createTime, @NotNull String endTime, @NotNull int state) {
        this.parkingLot = parkingLot;
        this.number = number;
        this.createTime = createTime;
        this.endTime = endTime;
        this.state = state;
    }

    public ParkingOrder() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"parkingLot\":")
                .append(parkingLot);
        sb.append(",\"number\":\"")
                .append(number).append('\"');
        sb.append(",\"createTime\":\"")
                .append(createTime).append('\"');
        sb.append(",\"endTime\":\"")
                .append(endTime).append('\"');
        sb.append(",\"state\":")
                .append(state);
        sb.append('}');
        return sb.toString();
    }
}
