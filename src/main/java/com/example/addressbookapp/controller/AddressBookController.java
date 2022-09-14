package com.example.addressbookapp.controller;


import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.dto.ResponseDTO;
import com.example.addressbookapp.model.AddressBook;
import com.example.addressbookapp.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
    //welcome message
    @Autowired
    AddressBookService service;
    @RequestMapping(value = {"", "/", "/home"}, method = RequestMethod.GET)
    public String greet() {
        return "Hello! This is Address Book Home Page";
    }
    //Adding data
    @PostMapping("/insert")
    public ResponseEntity<ResponseDTO> addUserData(@Valid @RequestBody AddressBookDTO addressBookData) {
        AddressBook response = service.saveData(addressBookData);
        ResponseDTO responseDTO = new ResponseDTO("Data Added Successfully",response);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    //get data by id
    @GetMapping("/id/{id}")
    public ResponseEntity<ResponseDTO> getEmpData(@PathVariable Long id) {
        Optional<AddressBook> addressBookData = service.findById(id);
        ResponseDTO respDTO= new ResponseDTO("User details by ID", addressBookData);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

    //get all the data
    @GetMapping("/all")
    public ResponseEntity<ResponseDTO> findAllData() {
        List<AddressBook> userDataList = service.findAllData();
        ResponseDTO respDTO = new ResponseDTO("All User Details Data", userDataList);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }
}
