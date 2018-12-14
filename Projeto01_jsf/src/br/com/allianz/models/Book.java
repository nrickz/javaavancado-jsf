package br.com.allianz.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Book {
	private int id;
	private String title;
	private String author;
	private Date publishDate;
	private double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public double getPrice() {
		return price;
	} 

	public void setPrice(double price) {
		this.price = price;
	}
	
	public Book () {}
	
	public Book (int pid, String ptitle, String pauthor, Date ppublishDate, double pprice) {
		super();
		this.id=pid;
		this.title=ptitle;
		this.author=pauthor;
		this.publishDate=ppublishDate;
		this.price=pprice;
	}

	public void setDataString(String dateString) {
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
			this.setPublishDate(date);
		} catch (Exception e) {
			this.setPublishDate(new Date());
		}
	}

}
