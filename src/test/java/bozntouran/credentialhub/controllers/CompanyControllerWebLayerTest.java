package bozntouran.credentialhub.controllers;


import bozntouran.credentialhub.entities.Company;
import bozntouran.credentialhub.services.CompanyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.connector.Request;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockReset;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(CompanyController.class)
@AutoConfigureMockMvc(addFilters = false)
public class CompanyControllerWebLayerTest {



    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    CompanyService companyService;

    private Company company;

    @BeforeEach
    public void setup() {
        company = new Company();
        company.setName("Company Name");
        company.setDescription("Company Description");
        company.setYearOfFoundation(1990);
    }


    @Test
    void createCompany() throws Exception {

        when(companyService.saveNewCompany(any(Company.class))).thenReturn(company);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/company")
                .contentType(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(company));


        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        String responseBodyAsString = mvcResult.getResponse().getContentAsString();

        Company responseCompany = new ObjectMapper().readValue(responseBodyAsString, Company.class);

        Assertions.assertEquals(company.getName(), responseCompany.getName());
        Assertions.assertEquals(company.getDescription(), responseCompany.getDescription());
        Assertions.assertEquals(company.getYearOfFoundation(), responseCompany.getYearOfFoundation());
    }
}
