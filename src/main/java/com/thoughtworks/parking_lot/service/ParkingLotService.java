package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import com.thoughtworks.parking_lot.service.serviceImp.ParkingServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingLotService implements ParkingServiceImp {

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Override
    public int addParkingLot(ParkingLot parkingLot) {
        try{
            parkingLotRepository.save(parkingLot);
            return 1;
        }
        catch (Exception e){}
        return 0;
    }

    @Override
    public int delParkingLot(String name) {
        try{
            parkingLotRepository.deleteById(name);
            return 1;
        }
        catch (Exception e){}
        return 0;
    }
}
