package com.faxb.controllers;

import com.faxb.model.Book;
import com.faxb.repository.RepositoryBook;

import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@Model
public class AdminBooksBean {
	
	private Book book = new Book();
	
	@Inject
	private RepositoryBook repositoryBook;

	@Transactional
	public void save(){
		repositoryBook.save(book);
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
}
