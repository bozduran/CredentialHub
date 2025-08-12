package bozntouran.reviewmycert.services;

import bozntouran.reviewmycert.dto.CompanyDto;
import bozntouran.reviewmycert.entities.Company;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CompanyService {
    Page<CompanyDto> getCompanies(String name, Integer pageNumber);
    Optional<Company> getCompanyById(long id);

    Company saveNewCompany(Company company);


    boolean deleteCompanyById(Long id);

    void updateCompany(Company updateCompany);
}
