package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ParkingLotServiceImp {
    int addParkingLot(ParkingLot parkingLot);
    int delParkingLot(String name);
    List<ParkingLot> findAllByPage(Integer page);
    ParkingLot findByName(String name);
    int updByCapacity(String name,Integer number);
}
