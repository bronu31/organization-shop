package com.example.service;

import com.example.entity.Reviews;
import com.example.entity.Sale;

import java.util.List;

interface  ReviewsService {

    List<Reviews> getAllReviews();

    Reviews saveReview(Reviews reviews);

}
