package bozntouran.credentialhub.services;

import bozntouran.credentialhub.entities.Certificate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CertificateService {

    List<Certificate> getCertificates();
    Optional<Certificate> getCertificate(long id);

    Certificate saveNewCertificate(Certificate certificate);

    boolean deleteCertificateById(Long id);
}
