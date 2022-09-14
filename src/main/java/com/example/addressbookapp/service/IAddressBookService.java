package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.model.AddressBook;

public interface IAddressBookService {
    AddressBook saveData(AddressBookDTO addressBookData);
}
