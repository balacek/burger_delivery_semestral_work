package com.semestralwork.burger_delivery;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.semestralwork.burger_delivery.dto.CustomerDto;
import com.semestralwork.burger_delivery.exception.CustomException;
import com.semestralwork.burger_delivery.service.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;
import java.util.regex.Pattern;

public class CustomerControllerTest extends TestAncestor {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    CustomerService customerService;

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

    @Test
    @Transactional
    public void wrongEmailRegistrationTest() throws Exception {
        mockMvc.perform(post("/api/customer/create-customer")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"David\",\"surname\":\"Balacek\"," +
                        "\"email\":\"david@cz\",\"password\":\"password\",\"phone\":" +
                        "\"774578478\",\"allowNewsletters\":false}"))
                .andExpect(status().isConflict());
    }

    @Test
    @Transactional
    public void blankNameSurnameRegistrationTest() throws Exception {
        mockMvc.perform(post("/api/customer/create-customer")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"\",\"surname\":\"\"," +
                        "\"email\":\"david@cz\",\"password\":\"password\",\"phone\":" +
                        "\"774578478\",\"allowNewsletters\":false}"))
                .andExpect(status().isConflict());
    }

    @Test
    @Transactional
    public void missingPhoneRegistrationTest() throws Exception {
        mockMvc.perform(post("/api/customer/create-customer")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"name\": \"David\",\n" +
                        "    \"surname\": \"Balacek\",\n" +
                        "    \"email\": \"david@seznam.cz\",\n" +
                        "    \"password\": \"password\",\n" +
                        "    \"allowNewsletters\": false\n" +
                        "}"))
                .andExpect(status().isConflict());
    }

    /**
     * Perform registration and then try to register again, same credencials shoul find the user and not create new one
     * @throws Exception
     */
    @Test
    @Transactional
    public void isAbleToFindExistingCustomerRegistrationTest() throws Exception {
       mockMvc.perform(post("/api/customer/create-customer")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"name\": \"David\",\n" +
                        "    \"surname\": \"Balacek\",\n" +
                        "    \"email\": \"david@seznam.cz\",\n" +
                        "    \"password\": \"password\",\n" +
                        "    \"phone\": \"774578478\",\n" +
                        "    \"allowNewsletters\": false\n" +
                        "}"))
                .andExpect(status().isCreated());

        int originalSize = getNumberOfCustomers();
        System.out.println("Puvodni velikost: " + originalSize);

        mockMvc.perform(post("/api/customer/create-customer")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"name\": \"David\",\n" +
                        "    \"surname\": \"Balacek\",\n" +
                        "    \"email\": \"david@seznam.cz\",\n" +
                        "    \"password\": \"password\",\n" +
                        "    \"phone\": \"774578478\",\n" +
                        "    \"allowNewsletters\": false\n" +
                        "}"))
                .andExpect(status().isCreated());

        int secondarySize = getNumberOfCustomers();
        System.out.println("Sekundarni velikost: " + originalSize);

        //check if the size is diffrent e.g. -> customer where created new one
        Assert.assertTrue(originalSize == secondarySize);
    }

    @Test
    @Transactional
    public void checkIfPasswordIsEncryptedRegistrationTest() throws Exception {
        Pattern BCRYPT_PATTERN = Pattern.compile("\\A\\$2a?\\$\\d\\d\\$[./0-9A-Za-z] {53}");

        insertCustomerForTest();
        String password = customerService.getCustomer("david@seznam.cz").getPassword();

        Assert.assertNotNull(password);
        Assert.assertTrue(!BCRYPT_PATTERN.matcher(password).matches());
    }

    @Test
    @Transactional
    public void willReturnCustomerDetailTest() throws Exception {
        insertCustomerForTest();
        ResultActions result = mockMvc.perform(get("/api/customer-detail?email=david@seznam.cz"))
                .andExpect(status().isOk());
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = objectMapper.readTree(result.andReturn().getResponse().getContentAsString());
        System.out.println(node.toString());
        Assert.assertNotNull(node);
        Assert.assertTrue(node.size() > 0);
    }

    @Test
    @Transactional
    public void noCustomerCustomerDetailTest() throws Exception {
        mockMvc.perform(get("/api/customer-detail?email=ahoj@seznam.cz"))
                .andExpect(status().isConflict());
    }

    @Test
    @Transactional
    public void willGetAllCustomersTest() throws Exception {
        insertCustomerForTest();
        ResultActions result = mockMvc.perform(get("/api/customer/customers"))
                .andExpect(status().isOk());
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = objectMapper.readTree(result.andReturn().getResponse().getContentAsString());
        Assert.assertNotNull(node);
        Assert.assertTrue(node.size() > 0);
    }

    @Test
    @Transactional
    public void customerDoesntExistCustomerOrdersTest() throws Exception {
        mockMvc.perform(get("/api/customer-orders?email=dada@ssss.cx"))
                .andExpect(status().isConflict());
    }

    @Transactional
    private int getNumberOfCustomers() throws Exception {
        ResultActions result =  mockMvc.perform(get("/api/customer/customers"))
                .andExpect(status().isOk());
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = objectMapper.readTree(result.andReturn().getResponse().getContentAsString());
        Assert.assertNotNull(node);
        return node.size();
    }

    @Transactional
    private void insertCustomerForTest() throws Exception {
        mockMvc.perform(post("/api/customer/create-customer")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"name\": \"David\",\n" +
                        "    \"surname\": \"Balacek\",\n" +
                        "    \"email\": \"david@seznam.cz\",\n" +
                        "    \"password\": \"password\",\n" +
                        "    \"phone\": \"774578478\",\n" +
                        "    \"allowNewsletters\": false\n" +
                        "}")).andExpect(status().isCreated());
    }
}
