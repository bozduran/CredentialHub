package bozntouran.reviewmycert.services;

import bozntouran.reviewmycert.entities.Certificate;
import bozntouran.reviewmycert.reposistories.CertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CertificateServiceImpl implements CertificateService{

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
}
