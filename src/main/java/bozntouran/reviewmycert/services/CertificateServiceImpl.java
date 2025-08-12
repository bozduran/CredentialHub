package bozntouran.reviewmycert.services;

import bozntouran.reviewmycert.dto.CertificateDto;
import bozntouran.reviewmycert.dto.CertificateField;
import bozntouran.reviewmycert.entities.Certificate;
import bozntouran.reviewmycert.reposistories.CertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static bozntouran.reviewmycert.mapper.CertificateMapper.MAPPER;

@Service
public class CertificateServiceImpl implements CertificateService{

    private static final int DEFAULT_PAGE = 0;
    private static final int DEFAULT_PAGE_SIZE = 9;

    private final CertificateRepository certificateRepository;

    @Autowired
    public CertificateServiceImpl(CertificateRepository certificateRepository){
        this.certificateRepository = certificateRepository;
    }



    @Override
    public List<Certificate> getCertificates() {
        return certificateRepository.findAll();
    }

    @Override
    public Optional<Certificate> getCertificate(long id) {
        return certificateRepository.findById(id);
    }

    @Override
    public Certificate saveNewCertificate(Certificate certificate) {
        return certificateRepository.save(certificate);
    }

    @Override
    public boolean deleteCertificateById(Long id) {
        if(certificateRepository.existsById(id) ){
            certificateRepository.deleteById(id);
            return true;
        }

        return false;
    }

    @Override
    public Page<CertificateDto> findAll(Long id,
                                        String name,
                                        Double startingRangePrice,
                                        Double endRangePrice,
                                        CertificateField certificateField,
                                        Integer pageNumber,
                                        Long companyId){
        PageRequest pageRequest = pageRequestBuilder(pageNumber, 0);
        if(id != null){
            return certificateRepository.findAllById(id, pageRequest).map((MAPPER::fromCertificate));
        }else if (companyId != null){
            return certificateRepository.findAllByCompany_Id(companyId, pageRequest).map((MAPPER::fromCertificate));
        } else if (startingRangePrice != null || endRangePrice != null ) {
            double startingRage = 0,endingRage =0;
            if (startingRangePrice != null) {
                startingRage = startingRangePrice;
            }
            if ( endRangePrice != null){
                endingRage = endRangePrice;
            }

            return certificateRepository.findAllByPriceBetween(startingRage, endingRage, pageRequest).map((MAPPER::fromCertificate));
        } else if ( name!=null) {
            return certificateRepository.findByNameContainingIgnoreCase(name, pageRequest).map((MAPPER::fromCertificate));
        }else if (certificateField != null){
            return certificateRepository.findByField(certificateField, pageRequest).map((MAPPER::fromCertificate));
        }

        return certificateRepository.findAll(pageRequest).map((MAPPER::fromCertificate));
    }

    @Override
    public void updateCertificate(Certificate updateCertificate) {

        certificateRepository.findById(updateCertificate.getId()).ifPresentOrElse(
                certificate -> {
                    if (updateCertificate.getCompany() != null) {
                        certificate.setCompany(updateCertificate.getCompany());
                    }
                    if (updateCertificate.getDescription() != null){
                        certificate.setDescription(updateCertificate.getDescription());
                    }
                    if(updateCertificate.getField() !=null){
                        certificate.setField(updateCertificate.getField());
                    }
                    if(updateCertificate.getName()!=null){
                        certificate.setName(updateCertificate.getName());
                    }
                    if(updateCertificate.getPrice()  >=0){
                        certificate.setPrice(updateCertificate.getPrice());
                    }
                    if(updateCertificate.getVersion() >= 0){
                        certificate.setVersion(updateCertificate.getVersion());
                    }
                    certificateRepository.save(certificate);
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
