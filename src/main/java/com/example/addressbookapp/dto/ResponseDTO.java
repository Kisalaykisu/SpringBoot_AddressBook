package com.example.addressbookapp.dto;

import com.example.addressbookapp.model.AddressBook;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
public class ResponseDTO {
    String message;
    Object response;

    public ResponseDTO(String message, Optional<AddressBook> response) {
        this.message = message;
        this.response = response;
    }

}
