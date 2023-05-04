package com.faxb.controllers;

import java.util.List;

import com.faxb.model.Book;
import com.faxb.repository.RepositoryBook;

import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;

@Model
public class HomeBean {

	@Inject
	private RepositoryBook repositoryBook;
	
	public List<Book> lastReleases(){
		return repositoryBook.lastReleases();
	}
	
	public List<Book> olderBooks(){
		return repositoryBook.olderBooks();
	}

}
