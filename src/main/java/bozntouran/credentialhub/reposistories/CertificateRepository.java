package bozntouran.credentialhub.reposistories;

import bozntouran.credentialhub.entities.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate,Long> {

}
