package com.thoughtworks.parking_lot.controller;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.entity.ParkingOrder;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import com.thoughtworks.parking_lot.repository.ParkingOrderRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ParkingOrderControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ParkingOrderRepository parkingOrderRepository;
    @MockBean ParkingLotRepository parkingLotRepository;
    private ParkingOrder parkingOrder;
    private ParkingLot parkingLot;
    private List<ParkingOrder> parkingOrders;
    @Before
    public void setUp(){
        parkingOrder = new ParkingOrder(null,"OOCL0209",String.valueOf(new Date().getTime()),String.valueOf(new Date().getTime()),0);
        parkingOrders = new ArrayList<>();parkingOrders.add(parkingOrder);
        parkingLot = new ParkingLot("jerryLi",2,"CSUST",parkingOrders);
    }

    @Test
    public void should_return_parking_order_when_given_a_car() throws Exception {
        Optional<ParkingLot> optionalParkingLot = Optional.of(parkingLot);
        when(parkingLotRepository.findById("jerryLi")).thenReturn(optionalParkingLot);
        when(parkingOrderRepository.save(parkingOrder)).thenReturn(parkingOrder);
        when(parkingLotRepository.save(parkingLot)).thenReturn(parkingLot);
        mockMvc.perform(post("/parking-orders/parking-lots/jerryLi/park-car/OOCL0209"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.number").value("OOCL0209"));
    }
}