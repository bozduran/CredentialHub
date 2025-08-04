package bozntouran.credentialhub.services;

import bozntouran.credentialhub.entities.Company;
import bozntouran.credentialhub.reposistories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Optional<Company> getCompanyById(long id) {
        return companyRepository.findById(id);
    }

    @Override
    public Company saveNewCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        if (companyRepository.existsById(id)){
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
