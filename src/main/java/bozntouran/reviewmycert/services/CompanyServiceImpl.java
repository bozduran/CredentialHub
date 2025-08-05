package bozntouran.reviewmycert.services;

import bozntouran.reviewmycert.entities.Company;
import bozntouran.reviewmycert.reposistories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    @Override
    public void updateCompany(Company updateCompany) {
        companyRepository.findById(updateCompany.getId()).ifPresentOrElse(
                (company)->{
                    if(updateCompany.getCertificates() != null){
                        company.setCertificates(updateCompany.getCertificates());
                    }
                    if(updateCompany.getDescription()!=null){
                        company.setDescription(updateCompany.getDescription());
                    }
                    if(updateCompany.getName()!=null){
                        company.setName(updateCompany.getName());
                    }
                    if(updateCompany.getYearOfFoundation()>0){
                        company.setYearOfFoundation(updateCompany.getYearOfFoundation());
                    }
                    companyRepository.save(company);
                },
                () -> {throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"); }

        );
    }
}
