package com.cg.bm.dao;

public interface IQueryMapper {
	
	public static final String ADD_BOOK = 
			"INSERT INTO book(bcode,  title, price, publishdate) VALUES(?,?,?,?)";
	public static final String MODIFY_BOOK = 
			"UPDATE book SET title=?,price=?,publishdate=? WHERE bcode=?";
	public static final String DEL_BOOK = 
			"DELETE FROM book WHERE bcode=?";
	public static final String GET_ALL_BOOKS = 
			"SELECT * FROM book";
	public static final String GET_BOOK = 
			"SELECT * FROM book WHERE bcode=?";

}
