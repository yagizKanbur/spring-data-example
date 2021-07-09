package com.tybootcamp.ecomm.services;

import com.tybootcamp.ecomm.entities.Profile;
import com.tybootcamp.ecomm.entities.Seller;
import com.tybootcamp.ecomm.models.SellerProfileDto;
import com.tybootcamp.ecomm.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class SellerService {
    private SellerRepository sellerRepository;

    @Autowired
    public SellerService(SellerRepository sellerRepository){
        this.sellerRepository = sellerRepository;
    }

    public Seller getSellerById(long id){
        Seller seller = sellerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        System.out.println("The seller with id " + id + " = " + seller.toString());
        return seller;
    }

    public Seller addNewSeller (SellerProfileDto sellerProfileDto){
        Seller seller = new Seller(sellerProfileDto.getSeller().getAccountId());
        Profile profile = new Profile(sellerProfileDto);
        seller.setProfile(profile);
        return sellerRepository.save(seller);
    }
}
