package bozntouran.credentialhub.services;

import bozntouran.credentialhub.entities.Certificate;
import bozntouran.credentialhub.reposistories.CertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
