package com.cg.bm.dao;

import java.util.List;
import com.cg.bm.exception.BookStoreException;
import com.cg.bm.model.Book;

public interface IBook {
	String add(Book book) throws BookStoreException;
	boolean delete (String bcode) throws BookStoreException;
	Book get(String bcode) throws BookStoreException;
	List<Book> getAll() throws BookStoreException;
	boolean update(Book book) throws BookStoreException;
}