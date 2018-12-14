package br.com.allianz.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.allianz.dao.BookDao;
import br.com.allianz.models.Book;

@ManagedBean(name = "BookBean")
@RequestScoped
public class BookBean {
	private Book book;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public BookBean() {
		if (book == null) {
			book = new Book();
		}
	}

	public String Insert() {		
		try {
//			FacesContext fc = FacesContext.getCurrentInstance();
//			FacesMessage fm = new FacesMessage();
//			fm.setDetail("");
//			fm.setDetail("");
//			fm.setDetail("");
//			fc.addMessage("", fm);
			new BookDao().Insert(book);
			return "ok";
		} catch (Exception e) {
			return "ok";
		}
	}

	public List<Book> getListBooks() throws Exception {
		Random r = new Random();
		List<Book> b = new ArrayList<Book>() ;
		for (int i = 0; i < 100; i++) {
			b.add(new Book(i, "Title "+r.nextInt(), "Author "+r.nextInt(), new Date(), r.nextDouble()));
		}
//		return new BookDao().List();
		return b;
	}
}