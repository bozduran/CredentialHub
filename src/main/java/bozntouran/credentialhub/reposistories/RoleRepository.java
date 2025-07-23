package bozntouran.credentialhub.reposistories;

import bozntouran.credentialhub.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role getRoleByName(String name);
}
