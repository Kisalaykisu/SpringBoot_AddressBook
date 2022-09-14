package com.example.addressbookapp.repo;

import com.example.addressbookapp.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface Repo extends JpaRepository<AddressBook, Long> {
    @Query(value="SELECT * FROM address_book, email_address WHERE user_id = id AND email = :email", nativeQuery=true)
    List<AddressBook> findUserByEmail(String email);
}
