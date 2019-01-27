package com.luv2code.springboot.cruddemo.service;


import com.luv2code.springboot.cruddemo.dao.AuthorDao;
import com.luv2code.springboot.cruddemo.dao.BookDao;
import com.luv2code.springboot.cruddemo.dao.ClientDao;
import com.luv2code.springboot.cruddemo.entity.Author;
import com.luv2code.springboot.cruddemo.entity.Book;
import com.luv2code.springboot.cruddemo.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ClientService {

    @Autowired
    BookDao bookDao;

    @Autowired
    AuthorDao authorDao;

    @Autowired
    ClientDao clientDao;
    public List<Client> getAllClients() {
        return clientDao.findAll();
    }


    public Optional<Client> getClientById(Long clientId) {
       /* if (!bookDao.existsById(bookId)) {
            //throw new TypeNotPresentException("Book with id " + bookId + " not found");
        }*/
        return clientDao.findById(clientId);
    }


    public Client createClient(Client client) {
        return clientDao.save(client);
    }

    //other methods omitted for brevity


    public void deleteById(Long clientId) {
        clientDao.deleteById(clientId);
    }

    public void setClientBook(Long clientId, Long bookId) {

        Set<Book> books = new HashSet<>();
        Client client1 = new Client();

        // get Book
        Optional<Book> bookById = bookDao.findById(bookId);
      /*  if (!byId.isPresent()) {
            //throw new ResourceNotFoundException("Author with id " + authorId + " does not exist");
        }*/
        Book book = bookById.get();

        // get client
        Optional<Client> clientById = clientDao.findById(clientId);
        Client client= clientById.get();

        // book set client
        book.setClient(client);
        books.add(book);

        // client set book
        client.setLoanedBooks(books);



    }
    //other methods omitted for brevity
}
