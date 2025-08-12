package bozntouran.reviewmycert.services;

import bozntouran.reviewmycert.dto.CompanyDto;
import bozntouran.reviewmycert.entities.Company;
import bozntouran.reviewmycert.mapper.CompanyMapper;
import bozntouran.reviewmycert.reposistories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private static final int DEFAULT_PAGE = 0;
    private static final int DEFAULT_PAGE_SIZE = 9;

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Page<CompanyDto> getCompanies(String name, Integer pageNumber) {

        PageRequest pageRequest = pageRequestBuilder(pageNumber, DEFAULT_PAGE_SIZE);

        if (name != null){
            return companyRepository.getAllByNameContainingIgnoreCase(name, pageRequest).map(CompanyMapper.MAPPER::fromCompany);
        }

        return companyRepository.findAll(pageRequest).map(CompanyMapper.MAPPER::fromCompany);
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

    public PageRequest pageRequestBuilder(Integer pageNumber, Integer pageSize){
        int queryPageSize ;
        int queryPageNumber;

        if (pageNumber != null && pageNumber > 0){
            queryPageNumber = pageNumber - 1;
        }else{
            queryPageNumber = DEFAULT_PAGE;
        }

        if (pageSize != null && pageSize > 0){
            if (pageSize > 250){
                queryPageSize = 250;
            }else{
                queryPageSize = pageSize;
            }
        }else{
            queryPageSize = DEFAULT_PAGE_SIZE;
        }

        Sort sort = Sort.by("name");

        return PageRequest.of(queryPageNumber, queryPageSize, sort);
    }
}
