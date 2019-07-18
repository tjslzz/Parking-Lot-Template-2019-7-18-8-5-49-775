package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingLotController {

    @Autowired
    private ParkingLotService parkingLotService;

    @PostMapping
    public int addParkingLot(@RequestBody ParkingLot parkingLot){
        return parkingLotService.addParkingLot(parkingLot);
    }

    @DeleteMapping("{name}")
    public int delParkingLot(@PathVariable String name){
        return parkingLotService.delParkingLot(name);
    }

    @GetMapping()
    public List<ParkingLot> findParkingLot(@RequestParam(value = "page",required = false)Integer page,@RequestParam(value = "pageSize") Integer pageSize){
        return parkingLotService.findAllByPage(page,pageSize);
    }
}
