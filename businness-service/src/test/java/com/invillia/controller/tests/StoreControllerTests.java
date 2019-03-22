package com.invillia.controller.tests;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.invillia.app.AppBusiness;

/*
 * Tests Store Controller
 * @since 21-03-2019
 * @author: Thiago Hernandes de Souza
 * */

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = AppBusiness.class)
public class StoreControllerTests {

	@Autowired
    private MockMvc mockMvc;
	
	public final String URL_BUSINESS_STORES = "http://business-service/api/stores";
	
	@Test
    public void returnAllStoresTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(URL_BUSINESS_STORES + "/all")
				  .accept(MediaType.APPLICATION_JSON))
				  .andExpect(status().isOk()).andReturn();
    }
    
    @Test
    public void returnStoreByIdTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(URL_BUSINESS_STORES + "/2")
				  .accept(MediaType.APPLICATION_JSON))
				  .andExpect(status().isOk()).andReturn();
    }
}
