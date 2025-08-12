package bozntouran.reviewmycert.services;

import bozntouran.reviewmycert.dto.ReviewDto;
import bozntouran.reviewmycert.entities.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ReviewService {

    Review saveNewReviewByCertificateId(Long id, String username, ReviewDto reviewDto);

    Page<ReviewDto> getAllReviews(Long certificateId, String username, Pageable pageable);

    Optional<ReviewDto> getReviewById(Long id);
}
