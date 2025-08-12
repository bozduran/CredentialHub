package bozntouran.reviewmycert.reposistories;

import bozntouran.reviewmycert.dto.CertificateField;
import bozntouran.reviewmycert.entities.Certificate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate,Long> {
    Page<Certificate> findAllByCompany_Id(Long companyId, Pageable pageable);

    Page<Certificate> findAllById(Long id, Pageable pageable);

    Page<Certificate> findAllByPriceBetween(double priceAfter, double priceBefore, Pageable pageable);

    Page<Certificate> findByName(String name, Pageable pageable);

    Page<Certificate> findByField(CertificateField field, Pageable pageable);

    Page<Certificate> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
