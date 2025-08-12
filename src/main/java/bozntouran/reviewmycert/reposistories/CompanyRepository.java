package bozntouran.reviewmycert.reposistories;

import bozntouran.reviewmycert.entities.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Page<Company> getAllByNameContainingIgnoreCase(String name, Pageable pageable);
}
