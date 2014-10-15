package com.mushroom;

public class book {
	private String isbn;
    private String title;
    private int authorid;
    private String publisher;
    private String publishdate;
	private double price;
	
    public book(){
    	
    }
    public book(String isbn, String title, int authorid, String publisher, String publishdate, double price) {
    	this.isbn = isbn;
    	this.title = title;
    	this.authorid = authorid;
    	this.publisher = publisher;
    	this.publishdate = publishdate;
    	this.price = price;
    }
    
    public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublishdate() {
		return publishdate;
	}
	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
