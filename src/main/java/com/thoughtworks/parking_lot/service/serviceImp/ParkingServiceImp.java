package com.thoughtworks.parking_lot.service.serviceImp;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import org.springframework.stereotype.Service;

@Service
public interface ParkingServiceImp {
    int addParkingLot(ParkingLot parkingLot);
}
