package com.olliniinioja.demo.yle.TeleText.controller;

import com.olliniinioja.demo.yle.TeleText.repository.ImageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(ImagesRestController.class)
@AutoConfigureDataMongo
class ImagesRestControllerTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ImageRepository repository;
//
//    @Test
//    public void testGetPageAndSubpageWithoutExt() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/v1/100/1.jpg?app_id=teletext&app_key=secret"))
//                .andExpect(MockMvcResultMatchers.status().isBadRequest())
//                .andExpect(MockMvcResultMatchers.content().string("Requested extension has to be png, was: jpg"));
//    }
//
//    @Test
//    public void testGetPageAndSubpageWithoutTimeParam() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/v1/somePage/someSubpage"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string("Requested page: somePage, Subpage: someSubpage"));
//    }

}