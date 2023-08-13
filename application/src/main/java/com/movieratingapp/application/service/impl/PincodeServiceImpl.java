package com.movieratingapp.application.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movieratingapp.application.config.PincodeDetailsResponse;
import com.movieratingapp.application.config.PostOfficeResponse;
import com.movieratingapp.application.exception.PincodeException;
import com.movieratingapp.application.service.PincodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PincodeServiceImpl implements PincodeService {

    private static final Logger logger = LoggerFactory.getLogger(PincodeServiceImpl.class);

    private static final String PINCODE_API_URL = "https://api.postalpincode.in/";

    @Autowired
    private RestTemplate restTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public PincodeServiceImpl(RestTemplate restTemplate) {
    }

    @Override
    public PincodeDetailsResponse getPincodeDetails(String pincode) {
        String url = PINCODE_API_URL + "pincode/" + pincode;
        logger.info("Making API request to URL: {}", url);

        try {
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
            String responseBody = responseEntity.getBody();

            PincodeDetailsResponse[] response = objectMapper.readValue(responseBody, PincodeDetailsResponse[].class);

            if (response != null && response.length > 0) {
                return response[0];
            } else {
                return new PincodeDetailsResponse();
            }
        } catch (HttpClientErrorException e) {
            logger.error("Error while fetching pincode details", e);
            throw new PincodeException("Error while fetching pincode details", e);
        } catch (Exception e) {
            logger.error("Error while processing pincode details", e);
            throw new PincodeException("Error while processing pincode details", e);
        }
    }

    @Override
    public PostOfficeResponse search(String searchValue) {
        String url = PINCODE_API_URL + "postoffice/" + searchValue;
        logger.info("Making API request to URL: {}", url);

        try {
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
            String responseBody = responseEntity.getBody();

            PostOfficeResponse[] responses = objectMapper.readValue(responseBody, PostOfficeResponse[].class);

            if (responses != null && responses.length > 0) {
                return responses[0];
            }
            return null;
        } catch (HttpClientErrorException e) {
            logger.error("Error while fetching post office details", e);
            throw new PincodeException("Error while fetching post office details", e);
        } catch (Exception e) {
            logger.error("Error while processing post office details", e);
            throw new PincodeException("Error while processing post office details", e);
        }
    }
}