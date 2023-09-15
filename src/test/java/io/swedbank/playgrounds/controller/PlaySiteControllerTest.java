package io.swedbank.playgrounds.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swedbank.playgrounds.dto.PlaySiteDto;
import io.swedbank.playgrounds.services.PlaySiteService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {PlaySiteController.class})
@ExtendWith(SpringExtension.class)
class PlaySiteControllerTest {
    @Autowired
    private PlaySiteController playSiteController;

    @MockBean
    private PlaySiteService playSiteService;

    /**
     * Method under test: {@link PlaySiteController#create(PlaySiteDto)}
     */
    @Test
    void testCreate() throws Exception {
        doNothing().when(playSiteService).create(Mockito.<PlaySiteDto>any());

        PlaySiteDto playSiteDto = new PlaySiteDto();
        playSiteDto.setEquipmentList(new ArrayList<>());
        playSiteDto.setName("Name");
        playSiteDto.setTotalEquipmentCount(3);
        playSiteDto.setTotalVisitors(1);
        String content = (new ObjectMapper()).writeValueAsString(playSiteDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/play-sites/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(playSiteController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link PlaySiteController#all()}
     */
    @Test
    void testAll() throws Exception {
        when(playSiteService.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/play-sites/all");
        MockMvcBuilders.standaloneSetup(playSiteController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link PlaySiteController#count()}
     */
    @Test
    void testCount() throws Exception {
        when(playSiteService.count()).thenReturn(3);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/play-sites/total-visitors");
        MockMvcBuilders.standaloneSetup(playSiteController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("3"));
    }
}

