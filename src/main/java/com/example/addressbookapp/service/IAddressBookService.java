package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.model.AddressBook;

import java.util.List;
import java.util.Optional;

public interface IAddressBookService {
    AddressBook saveData(AddressBookDTO addressBookData);

    Optional<AddressBook> findById(Long id);

    List<AddressBook> findAllData();
}
