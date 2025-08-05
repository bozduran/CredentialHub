package bozntouran.reviewmycert.reposistories;

import bozntouran.reviewmycert.entities.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege, Integer> {
}
