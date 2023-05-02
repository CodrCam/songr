package com.chamcocat.songr;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHelloRoute() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk());
    }

    @Test
    public void testCapitalizeRoute() throws Exception {
        mockMvc.perform(get("/capitalize/test"))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("TEST")));
    }

    @Test
    public void testSplashRoute() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    public void testAlbumsRoute() throws Exception {
        mockMvc.perform(get("/albums"))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("DAMN.")))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Traumazine")))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("I Decided.")));
    }
}
