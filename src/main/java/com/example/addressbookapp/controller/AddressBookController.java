package com.example.addressbookapp.controller;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.dto.ResponseDTO;
import com.example.addressbookapp.model.AddressBook;
import com.example.addressbookapp.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class AddressBookController {
    @Autowired
    IAddressBookService service;
    //welcome message
    @RequestMapping(value = {"", "/", "/home"}, method = RequestMethod.GET)
    public String greet() {
        return "Hello! This is Address Book Home Page";
    }

    //Adding data
    @PostMapping("/post")
    public ResponseEntity<ResponseDTO> addUserData(@Valid @RequestBody AddressBookDTO addressBookData) {
        AddressBook response = service.saveData(addressBookData);
        ResponseDTO responseDTO = new ResponseDTO("Data Added Successfully", Optional.ofNullable(response));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}