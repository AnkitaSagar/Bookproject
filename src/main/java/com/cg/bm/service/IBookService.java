package com.cg.bm.service;

import java.util.List;

import com.cg.bm.exception.BookStoreException;
import com.cg.bm.model.Book;

public interface IBookService {
	String add(Book book) throws BookStoreException;
	boolean delete(String bcode) throws BookStoreException;
	Book get(String bcode) throws BookStoreException;
	List<Book> getAll() throws BookStoreException;;
	boolean update(Book book) throws BookStoreException;
}