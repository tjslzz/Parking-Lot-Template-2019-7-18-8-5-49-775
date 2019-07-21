package com.thoughtworks.parking_lot.repository;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.entity.ParkingOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ParkingOrderRepositoryTest {
    @Autowired
    private ParkingLotRepository parkingLotRepository;
    @Autowired
    private ParkingOrderRepository parkingOrderRepository;

    private ParkingLot parkingLot;
    private ParkingOrder parkingOrder;
    private List<ParkingOrder> parkingOrders;
    @Before
    public void setUp(){
        parkingOrders = new ArrayList<>();
        parkingOrder = new ParkingOrder(null,"OOCL0209",String.valueOf(new Date().getTime()),String.valueOf(new Date().getTime()),0);
        parkingLot = new ParkingLot("jerryLi",2,"CSUST",parkingOrders);
    }

    @Test
    public void should_return_true_size_when_call_park_given_car(){
        parkingLotRepository.save(parkingLot);
        ParkingLot result = parkingLotRepository.findById("jerryLi").orElse(null);
        if(result.getCapacity()-result.getParkingOrders().size() > 0){
            parkingOrders.add(parkingOrder);
            result.setParkingOrders(parkingOrders);
            parkingLotRepository.save(result);
            parkingOrderRepository.save(parkingOrder);
        }

        assertEquals(2,parkingOrderRepository.findAll().size());
    }


    @Test
    public void should_return_false_info_when_call_park_given_car(){
        parkingOrders.add(parkingOrder);
        parkingOrders.add(parkingOrder);
        parkingLot.setParkingOrders(parkingOrders);
        parkingLotRepository.save(parkingLot);
        ParkingLot result = parkingLotRepository.findById("jerryLi").orElse(null);
        String str = "";
        if(result.getCapacity()-result.getParkingOrders().size() <= 0){
            str = "The parking lot is full";
        }
        assertEquals("The parking lot is full",str);
    }
}