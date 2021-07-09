package com.tybootcamp.ecomm.controllers;

import com.tybootcamp.ecomm.entities.Profile;
import com.tybootcamp.ecomm.entities.Seller;
import com.tybootcamp.ecomm.models.SellerProfileDto;
import com.tybootcamp.ecomm.repositories.ProductJpaRepository;
import com.tybootcamp.ecomm.repositories.SellerRepository;
import com.tybootcamp.ecomm.services.SellerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "/seller")
public class SellerController {
    @Autowired
    private SellerRepository _sellerRepository;

    @Autowired
    private SellerService sellerService;

    @GetMapping(path = "/")
    public ResponseEntity<?> getSellerById(@RequestParam(value = "id") long id)
    {
        // Check if id is valid
        return new ResponseEntity<>(sellerService.getSellerById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/")
    public ResponseEntity<?> addNewSeller(@Valid @RequestBody SellerProfileDto sellerProfileDto)
    {
        if(sellerProfileDto.getSeller() == null
                || StringUtils.isBlank(sellerProfileDto.getFirstName())
                || StringUtils.isBlank(sellerProfileDto.getLastName()) ){

            return new ResponseEntity<>("Missing necessary info", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(sellerService.addNewSeller(sellerProfileDto), HttpStatus.OK);
    }

    @PutMapping(path = "/")
    public ResponseEntity<String> updateSeller(@Valid @RequestBody Seller seller)
    {
        Seller sellerEntity = _sellerRepository.findById(seller.getId()).orElse(null);
        if (sellerEntity == null)
        {
            return new ResponseEntity<>("This seller doesn't exists.", HttpStatus.NOT_FOUND);
        }
        sellerEntity.setAccountId(seller.getAccountId());
        sellerEntity.getProfile().setFirstName(seller.getProfile().getFirstName());
        sellerEntity.getProfile().setLastName(seller.getProfile().getLastName());
        sellerEntity.getProfile().setWebsite(seller.getProfile().getWebsite());
        sellerEntity.getProfile().setBirthday(seller.getProfile().getBirthday());
        sellerEntity.getProfile().setAddress(seller.getProfile().getAddress());
        sellerEntity.getProfile().setEmailAddress(seller.getProfile().getEmailAddress());
        sellerEntity.getProfile().setGender(seller.getProfile().getGender());
        sellerEntity = _sellerRepository.save(sellerEntity);
        System.out.println("__________________________________________________________________");
        System.out.println("The row of " + sellerEntity.toString() + " updated");
        return new ResponseEntity<>("The seller updated", HttpStatus.OK);
    }
}
