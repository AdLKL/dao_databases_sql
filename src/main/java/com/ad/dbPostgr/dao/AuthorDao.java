package com.ad.dbPostgr.dao;

import java.util.List;
import java.util.Optional;

import com.ad.dbPostgr.domain.Author;

public interface AuthorDao {
	void create(Author author);

	Optional<Author> findOne(long l);
	
	List<Author> find();
	
	void update(long id, Author author);
	
	void delete(long id);
}
