package bozntouran.credentialhub.services;

import bozntouran.credentialhub.entities.Company;
import bozntouran.credentialhub.reposistories.CompanyRepository;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {
    List<Company> getCompanies();

    Company getCompanyById(long id);

    Company saveNewCompany(Company company);

}
