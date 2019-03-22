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
 * Tests Payment Controller
 * @since 21-03-2019
 * @author: Thiago Hernandes de Souza
 * */

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = AppBusiness.class)
public class PaymentControllerTests {

	@Autowired
    private MockMvc mockMvc;
	
	public final String URL_BUSINESS_PAYMENTS = "http://business-service/api/payments";

    @Test
    public void returnAllPaymentsTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(URL_BUSINESS_PAYMENTS + "/all")
				  .accept(MediaType.APPLICATION_JSON))
				  .andExpect(status().isOk()).andReturn();
    }
    
    @Test
    public void returnPaymentByIdTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(URL_BUSINESS_PAYMENTS + "/1")
				  .accept(MediaType.APPLICATION_JSON))
				  .andExpect(status().isOk()).andReturn();
    }
    
}
