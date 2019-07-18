package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.entity.ParkingOrder;
import org.springframework.stereotype.Service;

@Service
public interface ParkingOrderServiceImp {
    ParkingOrder addParkingOrder(String name,String car);
}
