package com.invillia.controller.tests;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.invillia.app.AppOrder;

/*
 * Tests ORder Controller
 * @since 21-03-2019
 * @author: Thiago Hernandes de Souza
 * */


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = AppOrder.class)
public class OrderControllerTests {

	@Autowired
    private MockMvc mockMvc;
	
	public final String URL_BUSINESS_ORDER = "http://order-service/api/orders";
	
	@Test
    public void returnOrderByIdTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(URL_BUSINESS_ORDER + "/10")
				  .accept(MediaType.APPLICATION_JSON))
				  .andExpect(status().isOk()).andReturn();
    }
	
	@Test
    public void deleteOrderByIdTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete(URL_BUSINESS_ORDER + "/delete/10")
				  .accept(MediaType.APPLICATION_JSON))
				  .andExpect(status().isOk()).andReturn();
    }
	
	@Test
    public void newOrderTest() throws Exception {
		String newOrder = "{"
				+ "\"buyDate\": \"2019-02-01\","
				+ "\"idStore\": 1,"
				+ "\"idPayment\": 2,"
				+ "\"status\": \"1\","
				+ "\"itens\" : ["
					+ "{"
					+ "\"idProduct\": 1, "
					+ "\"quantity\": 4, "
					+ "\"price\": 9.88 "
					+ "},"
					+ "{"
					+ "\"idProduct\": 2, "
					+ "\"quantity\": 5, "
					+ "\"price\": 9.33"
					+ "}"
					+"]"
			+"}";
		this.mockMvc.perform(MockMvcRequestBuilders.post(URL_BUSINESS_ORDER + "/new")
					.content(newOrder).contentType(MediaType.APPLICATION_JSON))
	    		    .andExpect(status().isOk());
    }
	
	@Test
    public void updateOrderByIdTest() throws Exception {
		String newOrder = "{"
				+ "\"id\": 13,"
				+ "\"buyDate\": \"2019-02-17\","
				+ "\"idStore\": 1,"
				+ "\"idPayment\": 2,"
				+ "\"status\": \"1\","
				+ "\"itens\" : ["
					+ "{"
					+ "\"idProduct\": 2, "
					+ "\"quantity\": 6, "
					+ "\"price\": 13 "
					+ "},"
					+ "{"
					+ "\"idProduct\": 1, "
					+ "\"quantity\": 50, "
					+ "\"price\": 8.20"
					+ "}"
					+"]"
			+"}";
		this.mockMvc.perform(MockMvcRequestBuilders.put(URL_BUSINESS_ORDER + "/update/13")
					.content(newOrder).contentType(MediaType.APPLICATION_JSON))
	    		    .andExpect(status().isOk());
    }
	
	@Test
    public void confirmOrderDatePaymentTest() throws Exception {
		Date dateConfirm = new Date();
		this.mockMvc.perform(MockMvcRequestBuilders.put(URL_BUSINESS_ORDER + "/confirm/13")
					.content(String.valueOf(dateConfirm.getTime()))
					.contentType(MediaType.APPLICATION_JSON))
	    		    .andExpect(status().isOk());
    }
}
