package com.movieratingapp.application.service;

import com.movieratingapp.application.config.PincodeDetailsResponse;
import com.movieratingapp.application.config.PostOfficeResponse;

import java.util.List;

public interface PincodeService {

    PincodeDetailsResponse getPincodeDetails(String pincode);

    PostOfficeResponse search(String searchValue);
}