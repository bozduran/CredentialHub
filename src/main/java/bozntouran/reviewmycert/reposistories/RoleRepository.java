package bozntouran.reviewmycert.reposistories;

import bozntouran.reviewmycert.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role getRoleByName(String name);
}
