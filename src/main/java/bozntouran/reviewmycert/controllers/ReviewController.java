package bozntouran.reviewmycert.controllers;

import bozntouran.reviewmycert.dto.ReviewDto;
import bozntouran.reviewmycert.dto.UserPrincipal;
import bozntouran.reviewmycert.entities.Review;
import bozntouran.reviewmycert.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {


    private final ReviewService reviewService;

    @Autowired
    private ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    private static final String REVIEW_URL = "/api/reviews";
    private static final String REVIEW_URL_ID = "/api/reviews/{id}";
    private static final String REVIEW_URL_FOR_POSTING = "/api/reviews-post/{id}";
    @GetMapping(REVIEW_URL_ID)
    public List<ReviewDto> getReviewsForACertificate(@PathVariable Long id){

        return reviewService.getCertificateDtoByCertificateId(id);
    }

    @PostMapping(REVIEW_URL_FOR_POSTING)
    public ResponseEntity addNewReviewForAUser(Authentication authentication,
                                               @PathVariable Long id,
                                               @Validated @RequestBody ReviewDto reviewDto){
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        Review savedReview = reviewService.saveNewReviewByCertificateId(id, userPrincipal.getUsername(), reviewDto);


        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location" , "/api/review/" + savedReview.getId());
        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);

    }
}
