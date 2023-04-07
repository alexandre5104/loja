package com.faxb.repository;

import java.util.List;

import com.faxb.model.Author;
import com.faxb.model.Book;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class RepositoryBook {

	@PersistenceContext
	private EntityManager manager;

	public void save(Book book) {
		manager.persist(book);
	}

	public List<Author> getAuthors(){
		return manager.createQuery("SELECT a FROM Author a", Author.class).getResultList();
	}

	public List<Book> list() {
		return manager.createQuery("select distinct(b) from Book b join fetch b.authors", Book.class)
				.getResultList();
	}
}
