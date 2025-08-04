package bozntouran.credentialhub.services;

import bozntouran.credentialhub.entities.Company;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CompanyService {
    List<Company> getCompanies();

    Optional<Company> getCompanyById(long id);

    Company saveNewCompany(Company company);


    boolean deleteCompanyById(Long id);
}
