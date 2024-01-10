package com.example.airdns.domain.review.service;

import com.example.airdns.domain.review.dto.ReviewsRequestDto;
import com.example.airdns.domain.review.dto.ReviewsResponseDto;
import com.example.airdns.global.jwt.UserDetailsImplV1;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface ReviewsService {
    ReviewsResponseDto.ReadReviewResponseDto getReview(Long roomId, Long reviewId);

    List<ReviewsResponseDto.ReadReviewResponseDto> getReviews(Long roomId);

    ReviewsResponseDto.CreateReviewResponseDto addReview(
            Long roomsId, UserDetailsImplV1 userDetails,
            ReviewsRequestDto.AddReviewRequestDto requestDto
    );

    ReviewsResponseDto.UpdateReviewResponseDto modifyReview(
            Long roomsId, Long reviewId, UserDetailsImplV1 userDetails,
            ReviewsRequestDto.UpdateReviewRequestDto requestDto
    );

    void removeReview(
            Long roomsId, Long reviewId, UserDetailsImplV1 userDetails
    );

}
