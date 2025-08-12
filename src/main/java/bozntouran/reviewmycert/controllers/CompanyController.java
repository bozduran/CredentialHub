package bozntouran.reviewmycert.controllers;

import bozntouran.reviewmycert.dto.CompanyDto;
import bozntouran.reviewmycert.entities.Company;
import bozntouran.reviewmycert.services.CompanyService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    public Page<CompanyDto> getAllCompanies(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer pageNumber) {
        return companyService.getCompanies(name, pageNumber);
    }

    @GetMapping(COMPANY_ID_URL)
    public Company getCompany(@PathVariable Long id) {
        return companyService.getCompanyById(id).orElse(null);
    }

    @PostMapping(COMPANY_URL)
    public Company createCompany(@RequestBody Company company) {
        log.info("Creating company {}", company);
        return companyService.saveNewCompany(company);
    }

    //only admins
    @PostMapping(COMPANY_URL + "-new")
    public ResponseEntity createNewCompany(@Validated @RequestBody Company company){
        Company newCompany = companyService.saveNewCompany(company);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location" , COMPANY_URL + "/"
        + newCompany.getId());

        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);

    }

    //only admins
    @DeleteMapping(COMPANY_URL+"-delete/{id}")
    public ResponseEntity deleteCompany(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        System.out.println(id);
        if (!companyService.deleteCompanyById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found");
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping(COMPANY_URL+"-patch")
    public ResponseEntity<Company> updateCompany(@RequestBody Company updateCompany){
        try{
            companyService.updateCompany(updateCompany);
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found");
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
