package com.example.demo.SpringBootDemo.accounts;

import com.example.demo.OpenBankingDemo.accounts.Accounts;
import com.example.demo.OpenBankingDemo.accounts.AccountsController;
import com.example.demo.OpenBankingDemo.accounts.AccountsRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = AccountsController.class)
class StatementsControllerTest {
    @Autowired
    AccountsRepository accountsRepository;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllAccounts() throws Exception {
        String expectedResponse = "[\n" +
                "{\n" +
                "accountId: 1,\n" +
                "status: \"Enabled\",\n" +
                "statusUpdateDateTime: \"2020/07/21\",\n" +
                "currency: \"USD\",\n" +
                "accountType: \"Business\",\n" +
                "openingDate: \"2018/01/11\"\n" +
                "},\n" +
                "{\n" +
                "accountId: 2,\n" +
                "status: \"Disabled\",\n" +
                "statusUpdateDateTime: \"2020/07/21\",\n" +
                "currency: \"USD\",\n" +
                "accountType: \"Business\",\n" +
                "openingDate: \"2018/01/11\"\n" +
                "}\n" +
                "]";
        Accounts accounts1 = new Accounts(
                1,
                "Enabled",
                "2020/07/21",
                "USD",
                "Business",
                "2018/01/11"
        );
        Accounts accounts2 = new Accounts(
                2,
                "Disabled",
                "2020/07/21",
                "USD",
                "Business",
                "2018/01/11"
        );
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/accounts");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        assertEquals(expectedResponse,result.getResponse().getContentAsString());
    }

    @Test
    void getAccountById() {
    }

    @Test
    public void getAllAccountsTest(){
        List<Accounts> accountsList = accountsRepository.findAll();
        assertNotNull(accountsList);
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


}