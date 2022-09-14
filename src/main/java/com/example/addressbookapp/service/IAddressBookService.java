package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.model.AddressBook;

import javax.mail.Address;
import java.util.List;
import java.util.Optional;

public interface IAddressBookService {
    AddressBook saveData(AddressBookDTO addressBookData);

    Optional<AddressBook> findById(Long id);

    List<AddressBook> findAllData();

    AddressBook editData(AddressBookDTO addressBookDTO, Long id);

    AddressBook deleteData(Long id);

    List<AddressBook> getUserByEmail(String email);

    List<AddressBook> getUserByCity(String city);

    List<AddressBook> getUserByState(String state);

    List<AddressBook> getUserByZip(String zip);

    String insertData(AddressBookDTO addressDto);

    Optional<AddressBook> getUserDataByToken(String token);

    List<AddressBook> getAllDataByToken(String token);

    String getTokenDetails(Long id);
}
