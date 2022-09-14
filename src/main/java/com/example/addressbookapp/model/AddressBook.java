package com.example.addressbookapp.model;

import com.example.addressbookapp.dto.AddressBookDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "Address_Book")
public @Data class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId")
    Long userId;
    @Column(name = "Full_Name")
    String fullName;
    String address;
    String city;
    String state;
    String zip;
    String contactNumber;
    @ElementCollection
    @CollectionTable(name = "Email_Address", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "emails")
    List<String> emailAddress;

    public AddressBook(AddressBookDTO addressBookData) {
//        this.userId = addressBookData.getUserId();
        this.fullName = addressBookData.getFullName();
        this.address = addressBookData.getAddress();
        this.city = addressBookData.getCity();
        this.state = addressBookData.getState();
        this.zip = addressBookData.getZip();
        this.contactNumber = addressBookData.getContactNumber();
        this.emailAddress = addressBookData.getEmailAddress();
    }
}
