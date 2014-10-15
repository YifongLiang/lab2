package com.mushroom;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class action extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1113450161790460949L;
	private String isbn;
	private String name;
	private book book;
	private List<book> books;
	private author author;
	private mysql m;

	public action() {
		m = new mysql();
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public book getBook() {
		return book;
	}

	public void setBook(book book) {
		this.book = book;
	}

	public List<book> getBooks() {
		return books;
	}

	public void setBooks(List<book> books) {
		this.books = books;
	}

	public author getAuthor() {
		return author;
	}

	public void setAuthor(author author) {
		this.author = author;
	}

	public String lookup() {
		book = m.getb(isbn);
		author = m.geta(book.getAuthorid());
		return SUCCESS;
	}

	public String list() {
		author = m.geta(name);
		books = m.getlistb(author.getAuthorid());
		return SUCCESS;
	}

	public String delete() {
		m.deleteb(isbn);
		return SUCCESS;
	}

	public String initdb() {
		m.initdb();
		return SUCCESS;
	}
}
