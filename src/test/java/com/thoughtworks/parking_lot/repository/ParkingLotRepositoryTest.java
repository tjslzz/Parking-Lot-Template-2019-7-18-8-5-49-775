package com.thoughtworks.parking_lot.repository;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
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
        parkingLot = new ParkingLot("jerryLi",10,"CSUST",new ArrayList<>());
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
            ParkingLot p = new ParkingLot("test"+i,10,"OOCL"+i,new ArrayList<>());
            parkingLotRepository.save(p);
        }
        List<ParkingLot> parkingLots = parkingLotRepository.findAll(PageRequest.of(page,15)).getContent();
        assertEquals(15,parkingLots.size());
    }

    @Test
    public void should_return_true_info_when_call_find_lot_given_name(){
        parkingLotRepository.save(parkingLot);
        ParkingLot result = parkingLotRepository.findById("jerryLi").orElse(null);
        assertEquals(10,result.getCapacity());
    }


    @Test
    public void should_return_true_info_when_call_upd_lot_given_name_and_new_size(){
        parkingLotRepository.save(parkingLot);
        ParkingLot result = parkingLotRepository.findById("jerryLi").orElse(null);
        result.setCapacity(result.getCapacity()+10);
        parkingLotRepository.save(result);
        assertEquals(20,parkingLotRepository.findById("jerryLi").orElse(null).getCapacity());
    }
}