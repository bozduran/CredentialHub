package bozntouran.credentialhub.controllers;

import bozntouran.credentialhub.entities.Company;
import bozntouran.credentialhub.services.CompanyService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@Log4j2
public class CompanyController {

    private static final String COMPANY_URL = "/api/company";
    private static final String COMPANY_ID_URL = "/api/company/{id}";

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }



    @GetMapping(COMPANY_URL)
    public List<Company> getAllCompanies() {
        return companyService.getCompanies();
    }

    @GetMapping(COMPANY_ID_URL)
    public Company getCompany(@PathVariable Long id) {
        return companyService.getCompanyById(id);
    }

    @PostMapping(COMPANY_URL)
    public Company createCompany(@RequestBody Company company) {
        log.info("Creating company {}", company);
        return companyService.saveNewCompany(company);
    }
}
