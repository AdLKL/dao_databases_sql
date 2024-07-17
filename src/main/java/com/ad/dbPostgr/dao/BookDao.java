package com.ad.dbPostgr.dao;

import java.util.List;
import java.util.Optional;

import com.ad.dbPostgr.domain.Book;

public interface BookDao {
	void create(Book book);
	
    Optional<Book> find(String isbn);
    
    List<Book> find();
    
    void update(String isbn, Book book);
}
