package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import com.thoughtworks.parking_lot.service.serviceImp.ParkingServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<ParkingLot> findAllByPage(Integer page, Integer size) {
        List<ParkingLot> parkingLots = new ArrayList<>();
        try{
            parkingLots = parkingLotRepository.findAll();
            return parkingLots.stream().skip((page-1)*size).limit(size).collect(Collectors.toList());
        }
        catch (Exception e){}
        return parkingLots;
    }
}
