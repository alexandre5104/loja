package com.faxb.controllers;

import java.io.FileInputStream;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.faxb.model.Book;
import com.faxb.repository.RepositoryBook;

import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;

@Model
public class ProductDetailBean {

	@Inject
	private RepositoryBook repositoryBook;

	private Book book = new Book();

	private StreamedContent image;

	public ProductDetailBean() {

		System.out.println("Imprimindo a imagem "+book.getCoverPath());
		
		image = DefaultStreamedContent.builder().stream(() -> {
			try {
				return new FileInputStream(book.getCoverPath());
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}).build();
	}

	public StreamedContent getImage() {
		return image;
	}

	private Integer id;

	public void loadBook() {
		System.out.println("Imprimindo o id " + id);
		this.setBook(repositoryBook.findById(id));
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
