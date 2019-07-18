package com.thoughtworks.parking_lot.serviceimp;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.entity.ParkingOrder;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import com.thoughtworks.parking_lot.repository.ParkingOrderRepository;
import com.thoughtworks.parking_lot.service.ParkingOrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ParkingOrderService implements ParkingOrderServiceImp {

    @Autowired
    private ParkingLotRepository parkingLotRepository;
    @Autowired
    private ParkingOrderRepository parkingOrderRepository;

    @Override
    public ParkingOrder addParkingOrder(String name,String car) {
        try{
            ParkingLot parkingLot = parkingLotRepository.findById(name).orElse(null);
            if(parkingLot.getCapacity()-parkingLot.getParkingOrders().size() > 0){
                ParkingOrder parkingOrder = new ParkingOrder(parkingLot.getName(),car,String.valueOf(new Date().getTime()),String.valueOf(new Date().getTime()),1);
                parkingLot.getParkingOrders().add(parkingOrder);
                parkingLotRepository.save(parkingLot);
                parkingOrderRepository.save(parkingOrder);
                return parkingOrder;
            }
        }
        catch (Exception e){}
        return null;
    }

    @Override
    public String delParkingOrder(String name, String car) {
        try{
            ParkingLot parkingLot = parkingLotRepository.findById(name).orElse(null);
            List<ParkingOrder> parkingOrders = parkingLot.getParkingOrders();
            ParkingOrder parkingOrder = parkingOrders.stream().filter(p -> p.getNumber().equalsIgnoreCase(car)).findFirst().orElse(null);
            parkingOrder.setState(0);
            parkingOrder.setEndTime(String.valueOf(new Date().getTime()));
            parkingOrders.stream().map(p -> p.getNumber().equalsIgnoreCase(car)?parkingOrder:p);
            return "car";
        }
        catch (Exception e){}
        return null;
    }
}
