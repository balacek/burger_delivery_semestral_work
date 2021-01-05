package com.semestralwork.burger_delivery;

import com.semestralwork.burger_delivery.service.CustomerService;
import com.semestralwork.burger_delivery.service.OrderService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class OrderControllerTest extends TestAncestor{

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    OrderService orderService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @Transactional
    public void correctRegistrationTest() throws Exception {
        mockMvc.perform(post("/api/customer/create-customer")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"David\",\"surname\":\"Balacek\"," +
                        "\"email\":\"david@seznam.cz\",\"password\":\"password\",\"phone\":" +
                        "\"774578478\",\"allowNewsletters\":false}"))
                .andExpect(status().isCreated());
    }
}
