package bozntouran.reviewmycert.services;

import bozntouran.reviewmycert.dto.CertificateDto;
import bozntouran.reviewmycert.dto.CertificateField;
import bozntouran.reviewmycert.entities.Certificate;
import org.springframework.data.domain.Page;
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
    Page<CertificateDto> findAll(Long id, String name, Double startingRangePrice, Double endRangePrice, CertificateField certificateField, Integer pageNumber, Long companyId);
}
