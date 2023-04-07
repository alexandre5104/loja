package com.faxb.controllers;

import java.util.ArrayList;
import java.util.List;

import com.faxb.model.Book;
import com.faxb.repository.RepositoryBook;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;

@Model
public class AdminListBooksBean {

	@Inject
	private RepositoryBook repositoryBook;
	
	private List<Book> books = new ArrayList<Book>();
	
	@PostConstruct
	private void loadObjects(){
		this.books = repositoryBook.list();
	}
	
	public List<Book> getBooks() {
		return books;
	}

}
