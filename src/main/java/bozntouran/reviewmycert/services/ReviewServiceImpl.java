package bozntouran.reviewmycert.services;

import bozntouran.reviewmycert.dto.ReviewDto;
import bozntouran.reviewmycert.entities.Certificate;
import bozntouran.reviewmycert.entities.Review;
import bozntouran.reviewmycert.entities.UserData;
import bozntouran.reviewmycert.mapper.ReviewMapper;
import bozntouran.reviewmycert.reposistories.CertificateRepository;
import bozntouran.reviewmycert.reposistories.ReviewRepository;
import bozntouran.reviewmycert.reposistories.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService{


    private final ReviewRepository reviewRepository;
    private final UserDataRepository userDataRepository;
    private final CertificateRepository certificateRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository,
                             UserDataRepository userDataRepository,
                             CertificateRepository certificateRepository){
        this.reviewRepository = reviewRepository;
        this.userDataRepository = userDataRepository;
        this.certificateRepository = certificateRepository;
    }

    public Review patchReviewByCertificateId(Certificate certificate, UserData userData, ReviewDto reviewDto){

        Review review = reviewRepository.findByUserData(userData);

        review.setComment(reviewDto.getComment());
        review.setStars(reviewDto.getStars());
        review.setUpdateDate(LocalDateTime.now());
        return reviewRepository.save(review);
    }

    @Override
    public Review saveNewReviewByCertificateId(Long id, String username, ReviewDto reviewDto) {
        Certificate certificate = certificateRepository.findById(id).orElse(null);
        UserData userData = userDataRepository.findUserByUsername(username);
        if ( certificate == null ){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found");
        }
        if (reviewRepository.existsByCertificateAndUserData(certificate,userData)){
            return patchReviewByCertificateId(certificate, userData, reviewDto);
        }

        Review review = new Review();

        review.setStars(reviewDto.getStars());
        review.setComment(reviewDto.getComment());
        review.setCertificate(certificate);
        review.setUserData(userData);
        review.setUpdateDate(LocalDateTime.now());
        review.setCreatedDate(LocalDateTime.now());

        return reviewRepository.save(review);
    }

    @Override
    public Page<ReviewDto> getAllReviews(Long certificateId, String username, Pageable pageable) {

        Page<Review> page;

        if (certificateId!=null){
            page = reviewRepository.getAllByCertificate_Id(certificateId, pageable);
        }else if (username!=null){
            page = reviewRepository.getAllByUserData_Username(username, pageable);
        }else{
            page = reviewRepository.findAll(pageable);
        }

        return page.map(ReviewMapper.MAPPER::fromReview);
    }

    @Override
    public Optional<ReviewDto> getReviewById(Long id) {
        return reviewRepository.findById(id).map(ReviewMapper.MAPPER::fromReview);
    }


}
