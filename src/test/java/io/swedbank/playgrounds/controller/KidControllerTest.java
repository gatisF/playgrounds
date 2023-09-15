package io.swedbank.playgrounds.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swedbank.playgrounds.dto.KidDto;
import io.swedbank.playgrounds.services.KidService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {KidController.class})
@ExtendWith(SpringExtension.class)
class KidControllerTest {
    @Autowired
    private KidController kidController;

    @MockBean
    private KidService kidService;

    /**
     * Method under test: {@link KidController#add(KidDto)}
     */
    @Test
    void testAdd() throws Exception {
        doNothing().when(kidService).add(Mockito.<KidDto>any());

        KidDto kidDto = new KidDto();
        kidDto.setAge(1);
        kidDto.setName("Name");
        kidDto.setPlaySiteName("Play Site Name");
        kidDto.setTicketNumber(1L);
        String content = (new ObjectMapper()).writeValueAsString(kidDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/kid/add-to-playsite")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(kidController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link KidController#remove(String, Long)}
     */
    @Test
    void testRemove() throws Exception {
        when(kidService.remove(Mockito.<String>any(), Mockito.<Long>any())).thenReturn(true);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/kid/remove-from-playsite/{name}/{ticketNumber}", "Name", 1L);
        MockMvcBuilders.standaloneSetup(kidController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link KidController#remove(String, Long)}
     */
    @Test
    void testRemove2() throws Exception {
        when(kidService.remove(Mockito.<String>any(), Mockito.<Long>any())).thenReturn(false);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/kid/remove-from-playsite/{name}/{ticketNumber}", "Name", 1L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(kidController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}

