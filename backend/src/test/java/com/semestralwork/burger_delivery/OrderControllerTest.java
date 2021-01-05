package com.semestralwork.burger_delivery;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.semestralwork.burger_delivery.service.CustomerService;
import com.semestralwork.burger_delivery.service.OrderService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
    public void correctCreateOrderTest() throws Exception {
        mockMvc.perform(post("/api/order/create-order")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"name\": \"ales\",\n" +
                        "    \"surname\": \"hudec\",\n" +
                        "    \"phone\": 4484545,\n" +
                        "    \"allowNewsletter\": false,\n" +
                        "    \"adress\": {\n" +
                        "        \"street\": \"jizedeee 47\",\n" +
                        "        \"city\": \"dadsadsadaxzcz\",\n" +
                        "        \"postalCode\": 7878\n" +
                        "    },\n" +
                        "    \"totalPrice\": 800,\n" +
                        "    \"burgers\": [{\n" +
                        "        \"burgerName\": \"burger\",\n" +
                        "        \"ingredients\": [\n" +
                        "            {\n" +
                        "                \"price\": 87,\n" +
                        "                \"amount\": 5,\n" +
                        "                \"type\": \"salad\"\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"price\": 154,\n" +
                        "                \"amount\": 5,\n" +
                        "                \"type\": \"bacon\"\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"price\": 200,\n" +
                        "                \"amount\": 5,\n" +
                        "                \"type\": \"meat\"\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    }]\n" +
                        "}"))
                .andExpect(status().isCreated());
    }

    @Test
    @Transactional
    public void missingCustomerValuesCreateOrderTest() throws Exception {
        mockMvc.perform(post("/api/order/create-order")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"allowNewsletter\": false,\n" +
                        "    \"adress\": {\n" +
                        "        \"street\": \"jizedeee 47\",\n" +
                        "        \"city\": \"dadsadsadaxzcz\",\n" +
                        "        \"postalCode\": 7878\n" +
                        "    },\n" +
                        "    \"totalPrice\": 800,\n" +
                        "    \"burgers\": [{\n" +
                        "        \"burgerName\": \"burger\",\n" +
                        "        \"ingredients\": [\n" +
                        "            {\n" +
                        "                \"price\": 87,\n" +
                        "                \"amount\": 5,\n" +
                        "                \"type\": \"salad\"\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"price\": 154,\n" +
                        "                \"amount\": 5,\n" +
                        "                \"type\": \"bacon\"\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"price\": 200,\n" +
                        "                \"amount\": 5,\n" +
                        "                \"type\": \"meat\"\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    }]\n" +
                        "}"))
                .andExpect(status().isConflict());
    }

    @Test
    @Transactional
    public void missingAddressCreateOrderTest() throws Exception {
        mockMvc.perform(post("/api/order/create-order")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"name\": \"ales\",\n" +
                        "    \"surname\": \"hudec\",\n" +
                        "    \"phone\": 4484545,\n" +
                        "    \"allowNewsletter\": false,\n" +
                        "    \"adress\": {\n" +
                        "        \"city\": \"dadsadsadaxzcz\",\n" +
                        "        \"postalCode\": 7878\n" +
                        "    },\n" +
                        "    \"totalPrice\": 800,\n" +
                        "    \"burgers\": [{\n" +
                        "        \"burgerName\": \"burger\",\n" +
                        "        \"ingredients\": [\n" +
                        "            {\n" +
                        "                \"price\": 87,\n" +
                        "                \"amount\": 5,\n" +
                        "                \"type\": \"salad\"\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"price\": 154,\n" +
                        "                \"amount\": 5,\n" +
                        "                \"type\": \"bacon\"\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"price\": 200,\n" +
                        "                \"amount\": 5,\n" +
                        "                \"type\": \"meat\"\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    }]\n" +
                        "}"))
                .andExpect(status().isConflict());
    }

    @Test
    @Transactional
    public void getOrdersTest() throws Exception {
        correctCreateOrderTest();
        ResultActions result =  mockMvc.perform(get("/api/orders"))
                .andExpect(status().isOk());
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = objectMapper.readTree(result.andReturn().getResponse().getContentAsString());
        Assert.assertNotNull(node);
        Assert.assertTrue(node.size() > 0);
    }
}
