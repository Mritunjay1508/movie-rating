package com.movieratingapp.application.controller;
import com.movieratingapp.application.config.PincodeDetailsResponse;
import com.movieratingapp.application.config.PostOfficeResponse;
import com.movieratingapp.application.service.PincodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pincode")
public class PincodeController {

    @Autowired
    private PincodeService pincodeService;

    @GetMapping("/{pincode}")
    public PincodeDetailsResponse getPincodeDetails(@PathVariable String pincode) {
        return pincodeService.getPincodeDetails(pincode);
    }

    @GetMapping("/search/{searchValue}")
    public PostOfficeResponse search(@PathVariable String searchValue) {
        PostOfficeResponse result = pincodeService.search(searchValue);
        return result;
    }
}