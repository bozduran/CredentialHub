package bozntouran.reviewmycert.reposistories;

import bozntouran.reviewmycert.entities.Certificate;
import bozntouran.reviewmycert.entities.Review;
import bozntouran.reviewmycert.entities.UserData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> getAllByCertificate_Id(Long certificateId);

    boolean existsByCertificateAndUserData(Certificate certificate, UserData userData);

    Review findByUserData(UserData userData);

    Page<Review> getAllByCertificate_Id(Long certificateId, Pageable pageable);

    Page<Review> getAllByUserData_Username(String userDataUsername, Pageable pageable);
}
