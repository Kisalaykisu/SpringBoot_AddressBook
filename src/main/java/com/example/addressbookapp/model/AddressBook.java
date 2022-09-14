package com.example.addressbookapp.model;

import com.example.addressbookapp.dto.AddressBookDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public @ToString  class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
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

        this.fullName = addressBookData.getFullName();
        this.address = addressBookData.getAddress();
        this.city = addressBookData.getCity();
        this.state = addressBookData.getState();
        this.zip = addressBookData.getZip();
        this.contactNumber = addressBookData.getContactNumber();
        this.emailAddress = addressBookData.getEmailAddress();
    }
}
