package com.example.addressbookapp.repo;

import com.example.addressbookapp.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface Repo extends JpaRepository<AddressBook, Long> {
}
