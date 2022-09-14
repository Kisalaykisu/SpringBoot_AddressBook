package com.example.addressbookapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
public @ToString class AddressBookDTO {
    String fullName;
    String address;
    String city;
    String state;
    Long zip;
    Long contactNumber;
    List<String> emailAddress;
}
