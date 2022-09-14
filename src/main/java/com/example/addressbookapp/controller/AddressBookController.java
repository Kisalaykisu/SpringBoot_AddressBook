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
import java.util.List;
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
        public ResponseEntity<ResponseDTO> addUserDataById(@Valid @RequestBody AddressBookDTO addressBookData) {
        AddressBook response = service.saveData(addressBookData);
        ResponseDTO responseDTO = new ResponseDTO("Data Added Successfully", Optional.ofNullable(response));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        }

    //get data by id
    @GetMapping("/id/{id}")
    public ResponseEntity<ResponseDTO> getUserData(@PathVariable Long id) {
        Optional<AddressBook> addressBookData = service.findById(id);
        ResponseDTO respDTO= new ResponseDTO("User Data with ID: " + id, addressBookData);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

    //get all the data
    @GetMapping("/all")
    public ResponseEntity<ResponseDTO> findAllData() {
        List<AddressBook> userDataList = service.findAllData();
        ResponseDTO respDTO = new ResponseDTO("All User Details Data", userDataList);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }
    //Edit or Update the data by id
    @PutMapping("/edit/{id}")
    public ResponseEntity<ResponseDTO> updateUserData(@PathVariable Long id,@Valid @RequestBody AddressBookDTO addressBookDTO) {
        Optional<AddressBook> userData = Optional.ofNullable(service.editData(addressBookDTO, id));
        ResponseDTO respDTO= new ResponseDTO("Data Update info", userData);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

    //Delete the data by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity <ResponseDTO> deleteUserData(@PathVariable Long id) {
        service.deleteData(id);
        ResponseDTO respDTO= new ResponseDTO("Deleted Successfully", "Deleted User ID: " + id);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

    //find the User details by email address
    @GetMapping("/email/{email}")
    public ResponseEntity <ResponseDTO> getUserByEmail(@PathVariable String email) {
        List<AddressBook> userDataList = service.getUserByEmail(email);
        ResponseDTO respDTO = new ResponseDTO("User Data with Email Address: " + email, userDataList);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

    //Find the User details by City
    @GetMapping("/city/{city}")
    public ResponseEntity <ResponseDTO> getUserByCity(@PathVariable String city) {
        List<AddressBook> userDataList = service.getUserByCity(city);
        ResponseDTO respDTO = new ResponseDTO("User Data with City: " + city, userDataList);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

    //Find the User details by State
    @GetMapping("/state/{state}")
    public ResponseEntity <ResponseDTO> getUserByState(@PathVariable String state) {
        List<AddressBook> userDataList = service.getUserByState(state);
        ResponseDTO respDTO = new ResponseDTO("User Data with State: " + state, userDataList);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

    //Find the User details by Zip Code
    @GetMapping("/zip/{zip}")
    public ResponseEntity <ResponseDTO> getUserByZip(@PathVariable String zip) {
        List<AddressBook> userDataList = service.getUserByZip(zip);
        ResponseDTO respDTO = new ResponseDTO("User Data with Zip Code: " + zip, userDataList);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }
}
