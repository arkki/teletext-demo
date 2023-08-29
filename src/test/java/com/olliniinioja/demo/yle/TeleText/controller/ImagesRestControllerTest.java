package com.olliniinioja.demo.yle.TeleText.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(ImagesRestController.class)
class ImagesRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetPageAndSubpageWithTimeParam() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/somePage/someSubpage")
                        .param("time", "12345"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Requested page: somePage, Subpage: someSubpage, Time: 12345"));
    }

    @Test
    public void testGetPageAndSubpageWithoutTimeParam() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/somePage/someSubpage"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Requested page: somePage, Subpage: someSubpage"));
    }

}