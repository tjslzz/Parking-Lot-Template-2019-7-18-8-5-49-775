package com.thoughtworks.parking_lot.repository;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ParkingLotRepositoryTest {
    @Autowired
    private ParkingLotRepository parkingLotRepository;
    private ParkingLot parkingLot;
    @Before
    public void setUp(){
        parkingLot = new ParkingLot("jerryLi",10,"CSUST");
    }

    @Test
    public void should_return_true_size_when_call_add_lot_given_one_parking_lot(){
        parkingLotRepository.save(parkingLot);
        assertEquals(1,parkingLotRepository.findAll().size());
    }

    @Test
    public void should_return_true_size_when_call_del_lot_given_one_parking_lot(){
        parkingLotRepository.save(parkingLot);
        parkingLotRepository.deleteById("jerryLi");
        assertEquals(0,parkingLotRepository.findAll().size());
    }

    @Test
    public void should_return_true_size_when_call_find_lot_given_page_size(){
        int page = 1;
        int pageSize = 15;
        for (int i = 0; i < 30; i++) {
            ParkingLot p = new ParkingLot("test"+i,10,"OOCL"+i);
            parkingLotRepository.save(p);
        }
        List<ParkingLot> parkingLots = parkingLotRepository.findAll();
        parkingLots = parkingLots.stream().skip((page-1)*pageSize).limit(pageSize).collect(Collectors.toList());
        assertEquals(15,parkingLots.size());
    }

    @Test
    public void should_return_true_info_when_call_find_lot_given_name(){
        parkingLotRepository.save(parkingLot);
        ParkingLot result = parkingLotRepository.findById("jerryLi").orElse(null);
        assertEquals(10,result.getCapacity());
    }
}