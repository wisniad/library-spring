package com.luv2code.springboot.cruddemo.service;


import com.luv2code.springboot.cruddemo.dao.AuthorDao;
import com.luv2code.springboot.cruddemo.dao.BookDao;
import com.luv2code.springboot.cruddemo.entity.Author;
import com.luv2code.springboot.cruddemo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BookService {

    @Autowired
    BookDao bookDao;

    @Autowired
    AuthorDao authorDao;

    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }


    public Optional<Book> getBookById(Long bookId) {
       /* if (!bookDao.existsById(bookId)) {
            //throw new TypeNotPresentException("Book with id " + bookId + " not found");
        }*/
        return bookDao.findById(bookId);
    }


    public Book createBook(Long authorId, Book book) {
        Set<Book> books = new HashSet<>();
        Author author1 = new Author();

        Optional<Author> byId = authorDao.findById(authorId);
        /*
            if (!byId.isPresent()) {
            //throw new ResourceNotFoundException("Author with id " + authorId + " does not exist");
        }*/
        Author author = byId.get();

        //tie Author to Book
        book.setAuthor(author);

        Book book1 = bookDao.save(book);
        //tie Book to Author
        books.add(book1);
        author1.setBooks(books);

        return book1;

    }

    public void deleteById(Long bookId) {
        bookDao.deleteById(bookId);
    }
    // other methods omitted for brevity
}
