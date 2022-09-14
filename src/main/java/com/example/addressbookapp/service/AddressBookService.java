package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.exception.AddressBookException;
import com.example.addressbookapp.model.AddressBook;
import com.example.addressbookapp.repository.AddressBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService implements IAddressBookService{
    @Autowired
    AddressBookRepo repository;
    public AddressBook saveData(AddressBookDTO addressBookData) {
        AddressBook addressBook = new AddressBook(addressBookData);
        return repository.save(addressBook);
    }

    @Override
    public Optional<AddressBook> findById(Long id) {
        Optional<AddressBook> getUserDetails = repository.findById(id);
        if (getUserDetails.isPresent()) {
            return repository.findById(id);
        } else
            throw new AddressBookException("ID does not exist " + id);
    }

    @Override
    public List<AddressBook> findAllData() {
        return repository.findAll();
    }
}

