package com.faxb.controllers;

import java.util.ArrayList;
import java.util.List;

import com.faxb.helpers.MessagesHelper;
import com.faxb.model.Author;
import com.faxb.model.Book;
import com.faxb.repository.RepositoryBook;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.inject.Model;
import jakarta.faces.application.FacesMessage;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@Model
public class AdminBooksBean {

	private Book book = new Book();

	@Inject
	private RepositoryBook repositoryBook;
	
	@Inject
	private MessagesHelper messageHelper;

	private List<Author> authors = new ArrayList<Author>();

	@PostConstruct
	public void loadObjects(){
		this.authors = repositoryBook.getAuthors();
	}

	@Transactional
	public String save(){
		repositoryBook.save(book);
			messageHelper.addFlash(new FacesMessage("Salvo com sucesso!"));
		return "/books/books?faces-redirect=true";
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public List<Author> getAuthors() {
		return authors;
	}

}
