package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.exception.AddressBookException;
import com.example.addressbookapp.model.AddressBook;
import com.example.addressbookapp.repo.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService implements IAddressBookService {
    @Autowired
    Repo repository;

    @Override
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

    @Override
    public AddressBook editData(AddressBookDTO addressBookDTO, Long id) {
        AddressBook existingData = repository.findById(id).orElse(null);
        if (existingData != null) {
            existingData.setFullName(addressBookDTO.getFullName());
            existingData.setAddress(addressBookDTO.getAddress());
            existingData.setCity(addressBookDTO.getCity());
            existingData.setState(addressBookDTO.getState());
            existingData.setZip(addressBookDTO.getZip());
            existingData.setContactNumber(addressBookDTO.getContactNumber());
            existingData.setEmailAddress(addressBookDTO.getEmailAddress());
            return repository.save(existingData);
        } else
            throw new AddressBookException("Error: Cannot find the User Id " + id);
    }

    @Override
    public void deleteData(Long id) {
    Optional<AddressBook> addressBookData = repository.findById(id);
        if(addressBookData.isPresent()){
            repository.deleteById(id);
        }else
            throw new AddressBookException("Error: Cannot find User ID " + id);
    }

    @Override
    public List<AddressBook> getUserByEmail(String email) {
        return repository.findUserByEmail(email);
    }


    @Override
    public List<AddressBook> getUserByCity(String city) {
        return repository.findUserByCity(city);
    }

    @Override
    public List<AddressBook> getUserByState(String state) {
        return repository.findUserByState(state);
    }

    @Override
    public List<AddressBook> getUserByZip(String zip) {
        return repository.findUserByZip(zip);    }

}
