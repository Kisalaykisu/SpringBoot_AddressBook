package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.model.AddressBook;
import com.example.addressbookapp.repo.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressBookService implements IAddressBookService{
    @Autowired
    Repo repository;
    @Override
    public AddressBook saveData(AddressBookDTO addressBookData) {
        AddressBook addressBook = new AddressBook(addressBookData);
        return repository.save(addressBook);
    }
}
