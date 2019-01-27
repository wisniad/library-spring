package com.luv2code.springboot.cruddemo.rest;


import com.luv2code.springboot.cruddemo.entity.Author;
import com.luv2code.springboot.cruddemo.entity.Book;
import com.luv2code.springboot.cruddemo.entity.Client;
import com.luv2code.springboot.cruddemo.service.AuthorService;
import com.luv2code.springboot.cruddemo.service.BookService;
import com.luv2code.springboot.cruddemo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
@RestController
public class AuthorBookController {

    @Autowired
    AuthorService authorService;

    @Autowired
    BookService bookService;

    @Autowired
    ClientService clientService;

    //Author
    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }


    @RequestMapping(value = "/authors", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Author createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    // Client
    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public List<Client> getClients() {
        return clientService.getAllClients();
    }


    @RequestMapping(value = "/clients", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @RequestMapping(value = "/clientbook", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void setClientBook(@RequestBody Long clientId, Long bookId) {
        clientService.setClientBook(clientId, bookId);
    }

    //Book
    @RequestMapping(value = "/{authorId}/books", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Book createBook(@PathVariable(value = "authorId") Long authorId, @RequestBody Book book) {
        return bookService.createBook(authorId, book);
    }

    @RequestMapping(value = "/books/{bookId}", method = RequestMethod.GET)
    public Optional<Book> getBookById(@PathVariable(value = "bookId") Long bookId) {
        return bookService.getBookById(bookId);
    }

    @RequestMapping(value = "/authors/{authorId}", method = RequestMethod.GET)
    public Optional<Author> getAuthorById(@PathVariable(value = "authorId") Long authorId) {
        return authorService.getAuthorById(authorId);
    }

    @RequestMapping(value = "/clients/{clientId}", method = RequestMethod.GET)
    public Optional<Client> getClientById(@PathVariable(value = "clientId") Long clientId) {
        return clientService.getClientById(clientId);
    }

    //others omitted for brevity

    /*@DeleteMapping("/books/{bookId}")
    public String deletelient(@PathVariable Long bookId) {
        bookService.deleteById(bookId);
        return "Deleted book";
    }*/
}