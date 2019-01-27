package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Book;
import com.luv2code.springboot.cruddemo.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@CrossOrigin(origins = "*")
@Repository
public interface ClientDao extends JpaRepository<Client, Long> {

}
