package com.thoughtworks.parking_lot.service.serviceImp;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ParkingServiceImp {
    int addParkingLot(ParkingLot parkingLot);
    int delParkingLot(String name);
    List<ParkingLot> findAllByPage(Integer page,Integer size);
}
