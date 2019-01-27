package com.luv2code.springboot.cruddemo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Client")
public class Client implements Serializable {

    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private Set<Book> loanedBooks = new HashSet<>();


    public Client() {
    }

    public Set<Book> getLoanedBooks() {
        return loanedBooks;
    }

    public void setLoanedBooks(Set<Book> loanedBooks) {
        this.loanedBooks = loanedBooks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public Client(String firstName, String lastName, Set<Book> loanedBooks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.loanedBooks = loanedBooks;
    }
}