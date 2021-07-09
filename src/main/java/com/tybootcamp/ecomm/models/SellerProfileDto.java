package com.tybootcamp.ecomm.models;

import com.tybootcamp.ecomm.entities.Customer;
import com.tybootcamp.ecomm.entities.Seller;
import com.tybootcamp.ecomm.enums.Gender;

import java.util.Date;

public class SellerProfileDto {
    private Long profileId;
    private String firstName;
    private String lastName;

    private String website;
    private Date birthday;
    private String address;
    private String emailAddress;

    private Gender gender;

    private Seller seller;

    public SellerProfileDto(Seller seller ,Long profileId, String firstName, String lastName) {
        this.seller = seller;
        this.profileId = profileId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public SellerProfileDto(Seller seller ,Long profileId, String firstName, String lastName, String website, Date birthday, String address, String emailAddress, Gender gender) {
        this.seller = seller;
        this.profileId = profileId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.website = website;
        this.birthday = birthday;
        this.address = address;
        this.emailAddress = emailAddress;
        this.gender = gender;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
