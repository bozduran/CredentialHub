package bozntouran.reviewmycert.services;

import bozntouran.reviewmycert.entities.Certificate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CertificateService {

    List<Certificate> getCertificates();
    Optional<Certificate> getCertificate(long id);

    Certificate saveNewCertificate(Certificate certificate);

    boolean deleteCertificateById(Long id);

    void updateCertificate(Certificate updateCertificate);
}
