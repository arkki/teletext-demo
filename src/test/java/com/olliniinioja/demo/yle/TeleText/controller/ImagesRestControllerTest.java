package com.olliniinioja.demo.yle.TeleText.controller;

import com.olliniinioja.demo.yle.TeleText.model.Image;
import com.olliniinioja.demo.yle.TeleText.repository.FileRepository;
import com.olliniinioja.demo.yle.TeleText.repository.ImageRepository;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.util.Optional;

@WebMvcTest(ImagesRestController.class)
@EnableAutoConfiguration(exclude = {MongoAutoConfiguration.class})
class ImagesRestControllerTest {

    private static final String CREDENTIALS = "app_id=teletext&app_key=secret";
    private static final String IMAGE = "test.png";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ImageRepository repository;

    @MockBean
    private FileRepository fileRepository;

    @Test
    public void testGetPageWithUnsupportedExtension() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(String.format("/v1/100/1.jpg?%s", CREDENTIALS)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void testGetPageNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(String.format("/v1/9999/9999.png?%s", CREDENTIALS)))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void testGetPageAndSubpage() throws Exception {
        int page = 100;
        int subpage = 1;
        Mockito.when(repository.findOneByPage(page, subpage)).thenReturn(Optional.of(new Image(page, subpage, IMAGE)));

        try (InputStream in = this.getClass().getClassLoader().getResourceAsStream(IMAGE)) {
            byte[] expectedBytes = IOUtils.toByteArray(in);
            Mockito.when(fileRepository.getFile(Mockito.any())).thenReturn(new ByteArrayInputStream(expectedBytes));

            mockMvc.perform(MockMvcRequestBuilders.get(String.format("/v1/%s/%s.png?%s", page, subpage, CREDENTIALS)))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.IMAGE_PNG))
                    .andExpect(MockMvcResultMatchers.content().bytes(expectedBytes));
        }

    }

    @Test
    public void testGetPageAndSubpageAndTime() throws Exception {
        int page = 100;
        int subpage = 1;
        int epoch = 1693826019;
        Instant time = Instant.ofEpochSecond(epoch);
        Mockito.when(repository.findOneByPageAndTime(page, subpage, time)).thenReturn(Optional.of(new Image(page, subpage, IMAGE)));

        try (InputStream in = this.getClass().getClassLoader().getResourceAsStream(IMAGE)) {
            byte[] expectedBytes = IOUtils.toByteArray(in);
            Mockito.when(fileRepository.getFile(Mockito.any())).thenReturn(new ByteArrayInputStream(expectedBytes));

            mockMvc.perform(MockMvcRequestBuilders.get(String.format("/v1/%s/%s.png?%s&time=%s", page, subpage, CREDENTIALS, epoch)))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.IMAGE_PNG))
                    .andExpect(MockMvcResultMatchers.content().bytes(expectedBytes));
        }
    }
}