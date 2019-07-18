package com.thoughtworks.parking_lot.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class ParkingOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @NotNull
    private String name;

    @NotNull
    private String number;
    @NotNull
    private String createTime;
    @NotNull
    private String endTime;
    @NotNull
    private int state;


    public ParkingOrder(@NotNull String name, @NotNull String number, @NotNull String createTime, @NotNull String endTime, @NotNull int state) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
