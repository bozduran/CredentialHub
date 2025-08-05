package bozntouran.reviewmycert.services;

import bozntouran.reviewmycert.dto.ReviewDto;
import bozntouran.reviewmycert.entities.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {
    List<ReviewDto> getCertificateDtoByCertificateId(Long certificateID);

    Review saveNewReviewByCertificateId(Long id, String username, ReviewDto reviewDto);
}
