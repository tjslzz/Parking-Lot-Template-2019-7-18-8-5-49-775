package com.thoughtworks.parking_lot.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
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

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ParkingLotControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ParkingLotRepository parkingLotRepository;

    private ParkingLot parkingLot;
    @Before
    public void setUp(){
        parkingLot = new ParkingLot("jerryLi",10,"CSUST",new ArrayList<>());
    }

    @Test
    public void should_return_1_wehn_given_a_lot_to_add() throws Exception {
        when(parkingLotRepository.save(parkingLot)).thenReturn(parkingLot);
        mockMvc.perform(post("/parking-lots").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(parkingLot.toString()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$").value(1));
    }

    @Test
    public void should_return_1_wehn_given_a_lot_name_to_del() throws Exception {
        mockMvc.perform(delete("/parking-lots/jerryLi"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$").value(1));
    }

    @Test
    public void should_return_jerry_li_wehn_get_all_lots() throws Exception {
        mockMvc.perform(get("/parking-lots",1))
                .andDo(print())
                .andExpect(status().isOk());
    }
}