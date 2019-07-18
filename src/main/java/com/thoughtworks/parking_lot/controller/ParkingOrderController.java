package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.entity.ParkingOrder;
import com.thoughtworks.parking_lot.serviceimp.ParkingOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parking-orders")
public class ParkingOrderController {

    @Autowired
    private ParkingOrderService parkingOrderService;

    @PostMapping("/parking-lots/{name}/park-car/{car}")
    public ParkingOrder addParkingOrder(@PathVariable("name") String name,@PathVariable("car")String car){
        return parkingOrderService.addParkingOrder(name,car);
    }

    @DeleteMapping("/parking-lots/{name}/park-car/{car}")
    public String delParkingOrder(@PathVariable("name") String name,@PathVariable("car")String car){
        return parkingOrderService.delParkingOrder(name,car);
    }
}
