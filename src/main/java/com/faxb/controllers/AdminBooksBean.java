package com.faxb.controllers;

import com.faxb.model.Book;

import jakarta.enterprise.inject.Model;

@Model
public class AdminBooksBean {
	
	private Book book = new Book();

	public void save(){
		System.out.println(book);
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
}
