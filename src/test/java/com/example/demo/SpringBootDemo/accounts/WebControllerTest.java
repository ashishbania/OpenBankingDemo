package com.example.demo.SpringBootDemo.accounts;

import com.example.demo.OpenBankingDemo.OpenBankingDemo;
import com.example.demo.OpenBankingDemo.accounts.Accounts;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = OpenBankingDemo.class)
@SpringBootTest
public class WebControllerTest {
    private MockMvc mockMvc;

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void verifyAllAccounts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/accounts/").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2))).andDo(print());
    }
    @Test
    public void verifyAccountsById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/accounts/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.accountId").exists())
                .andExpect(jsonPath("$.status").exists())
                .andExpect(jsonPath("$.accountType").exists())
                .andExpect(jsonPath("$.accountId").value(1))
                .andExpect(jsonPath("$.status").value("Enabled"))
                .andExpect(jsonPath("$.accountType").value("Business"))
                .andDo(print());
    }

    @Test
    public void verifyAddAccounts() throws Exception{
//        mockMvc.perform(MockMvcRequestBuilders.post().accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNotFound());

        String url = "/api/v1/accounts/";
        Accounts accounts = new Accounts();
        accounts.setAccountId(100);
        accounts.setAccountType("Business");
        accounts.setCurrency("UCD");
        accounts.setOpeningDate("2018/01/11");
        accounts.setStatusUpdateDateTime("2020/07/21");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(accounts );
        mockMvc.perform(MockMvcRequestBuilders.post(url).contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(status().isOk());
//        System.out.println("We are inside verify Add Accounts");

    }

    @Test
    public void removeAccountByID() throws Exception{
        System.out.println("We are inside verify remove Accounts");
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/accounts/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }}