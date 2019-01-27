package com.luv2code.springboot.cruddemo.service;


import com.luv2code.springboot.cruddemo.dao.AuthorDao;
import com.luv2code.springboot.cruddemo.entity.Author;
import com.luv2code.springboot.cruddemo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    AuthorDao authorDao;

    public List<Author> getAuthors() {
        return authorDao.findAll();
    }

    public Author createAuthor(Author author) {
        return authorDao.save(author);
    }

    //other methods omitted for brevity
    public Optional<Author> getAuthorById(Long authorId) {
        if (!authorDao.existsById(authorId)) {
            //throw new TypeNotPresentException("Book with id " + bookId + " not found");
        }
        return authorDao.findById(authorId);
    }

}
