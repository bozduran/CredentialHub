package bozntouran.reviewmycert.reposistories;

import bozntouran.reviewmycert.entities.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Long> {

    UserData findUserByUsername(String username);

}
