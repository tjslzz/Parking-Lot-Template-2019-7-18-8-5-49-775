package com.thoughtworks.parking_lot.serviceimp;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import com.thoughtworks.parking_lot.service.ParkingLotServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkingLotService implements ParkingLotServiceImp {

    private static final int PAGE_SIZE = 15;


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
    public List<ParkingLot> findAllByPage(Integer page) {
        List<ParkingLot> parkingLots = new ArrayList<>();
        try{
            parkingLots = parkingLotRepository.findAll();
            return parkingLots.stream().skip((page-1)*PAGE_SIZE).limit(PAGE_SIZE).collect(Collectors.toList());
        }
        catch (Exception e){}
        return parkingLots;
    }

    @Override
    public ParkingLot findByName(String name) {
        try{
            return parkingLotRepository.findById(name).orElse(null);
        }
        catch (Exception e){}
        return null;
    }

    @Override
    public int updByCapacity(String name, Integer number) {
        try{
            ParkingLot parkingLot = parkingLotRepository.findById(name).orElse(null);
            parkingLot.setCapacity(number);
            parkingLotRepository.save(parkingLot);
            return 1;
        }
        catch (Exception e){}
        return 0;
    }
}
