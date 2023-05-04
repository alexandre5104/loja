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
		return manager.createQuery("SELECT DISTINCT(b) FROM Book b JOIN FETCH b.authors", Book.class)
				.getResultList();
	}

	public List<Book> lastReleases() {
		return manager.createQuery("SELECT b FROM Book b ORDER BY b.id desc", Book.class)
				.setMaxResults(3).getResultList();
	}
	public List<Book> olderBooks() {
		return manager.createQuery("SELECT b FROM Book b",Book.class).setMaxResults(20).getResultList();
	}

	public Book findById(Integer id) {
		return manager.find(Book.class, id);
	}
}
