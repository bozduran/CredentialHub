package bozntouran.credentialhub.reposistories;

import bozntouran.credentialhub.entities.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege, Integer> {
}
