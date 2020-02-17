package com.mixapp.venitar.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mixapp.venitar.entity.MixesUpload;
import com.mixapp.venitar.service.MixesUploadService;
import com.sun.deploy.uitoolkit.impl.fx.ui.MixedCodeInSwing;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



public class VenitarControllerTest {

    private MockMvc mockMvc;

        @Autowired
        private WebApplicationContext webApplicationContext;

        @MockBean
        private MixesUploadService mixesUploadService;

        @Before
        public void setup() throws Exception {
            MockitoAnnotations.initMocks(this);
            this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).dispatchOptions(true).build();
        }
        public static String asJsonString(MixesUpload mixesUpload){
            try {
                final ObjectMapper mapper = new ObjectMapper();
                final String jsonContent = mapper.writeValueAsString(mixesUpload);
                return jsonContent;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        @Test
        public void all() throws Exception {
            String expected="[ {\n" +
                    "  \"mixId\" : 4,\n" +
                    "  \"mixCompany\" : \"Kvent Test\",\n" +
                    "  \"mixDjName\" : \"Jabawhosky\",\n" +
                    "  \"mixStatus\" : \"Allowed\",\n" +
                    "  \"mixLink\" : \"50Cent\",\n" +
                    "  \"mixTitle\" : \"Date.valueOf\",\n" +
                    "} ]";
            MixesUpload mixesUpload = new MixesUpload();
            mixesUpload.setMixId(4l);
            mixesUpload.setMixCompany("Kvent Test");
            mixesUpload.setMixDjName("Jabawhosky");
            mixesUpload.setMixStatus("Allowed");
            mixesUpload.setMixLink("50Cent");
            mixesUpload.setMixTitle("Date.valueOf");
            List<MixesUpload> mixesUploadList = Arrays.asList(mixesUpload);

            given(mixesUploadService.getAllMixes()).willReturn(mixesUploadList);

            this.mockMvc.perform(get("/getAllMixes/")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().string(expected))
                    .andDo(print());


        }




}
