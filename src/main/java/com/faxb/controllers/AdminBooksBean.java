package com.faxb.controllers;

import java.util.ArrayList;
import java.util.List;

import com.faxb.model.Author;
import com.faxb.model.Book;
import com.faxb.repository.RepositoryBook;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@Model
public class AdminBooksBean {

	private Book book = new Book();

	@Inject
	private RepositoryBook repositoryBook;

	public List<Integer> getSelectedAuthorsIds() {
		return selectedAuthorsIds;
	}

	public void setSelectedAuthorsIds(List<Integer> selectedAuthorsIds) {
		this.selectedAuthorsIds = selectedAuthorsIds;
	}

	private List<Integer> selectedAuthorsIds = new ArrayList<Integer>();

	private List<Author> authors = new ArrayList<Author>();

	@PostConstruct
	public void loadObjects(){
		this.authors = repositoryBook.getAuthors();
	}


	@Transactional
	public void save(){
		populateBookAuthor();
		repositoryBook.save(book);
		clearObjects();
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	private void populateBookAuthor() {
		selectedAuthorsIds.stream().map((id) -> { 
			return new Author(id); 
		}).forEach(book::add);
	}

	public List<Author> getAuthors() {
		return authors;
	}

	private void clearObjects() {
		this.book = new Book();
		this.selectedAuthorsIds.clear();
	}

}
