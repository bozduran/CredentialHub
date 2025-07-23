package bozntouran.credentialhub.reposistories;

import bozntouran.credentialhub.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
