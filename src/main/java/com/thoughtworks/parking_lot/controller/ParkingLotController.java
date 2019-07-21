package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.serviceimp.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking-lots")
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
    public List<ParkingLot> findParkingLot(@RequestParam(value = "page",required = false,defaultValue = "1")Integer page){
        return parkingLotService.findAllByPage(page);
    }

    @GetMapping("{name}")
    public ParkingLot findParkingLot(@PathVariable String name){
        return parkingLotService.findByName(name);
    }

    @PutMapping("{name}/capacity/{number}")
    public int putParkingLot(@PathVariable("name") String name,@PathVariable("number") Integer number){
        return parkingLotService.updByCapacity(name,number);
    }
}
