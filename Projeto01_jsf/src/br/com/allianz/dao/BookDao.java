package br.com.allianz.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.allianz.models.Book;

public class BookDao extends Dao {
	public void Insert(Book book) throws Exception {
		try {
			openConnection();
			String sql = "INSERT INTO Livrodb VALUES (?,?,?,?)";
			stmt = cn.prepareStatement(sql);
			stmt.setString(1, book.getTitle());
			stmt.setString(2, book.getAuthor());
			stmt.setDate(3, new java.sql.Date(book.getPublishDate().getTime()));
			stmt.setDouble(4, book.getPrice());
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			closeConnection();
		}
	}

	public List<Book> List() throws Exception {
		List<Book> books = new ArrayList<>();
		try {
			stmt = cn.prepareStatement("SELECT * FROM Livrodb");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Book book = new Book(rs.getInt("Id"), rs.getString("Titulo"), rs.getString("Autor"),
						rs.getDate("DataPub"), rs.getDouble("Preco"));
				books.add(book);
			}
		} catch (Exception e) {
			throw e;	
		} finally {
			cn.close();
		};
		return books;
	}
}
