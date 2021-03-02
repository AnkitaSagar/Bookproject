package com.cg.bm.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.bm.dao.BookJDBCImpl;
import com.cg.bm.dao.IBook;
import com.cg.bm.exception.BookStoreException;
import com.cg.bm.model.Book;


public class BookService implements IBookService{
	private IBook bookDao;
	
	public IBook getDAO(){
		return bookDao;
	}
	
	public BookService() throws BookStoreException {
		bookDao = new BookJDBCImpl();
	}
	
public boolean isValidBcode(String bcode) {
		Pattern bcodePattern = Pattern.compile("[A-Z]\\d{3}");
		Matcher bcodeMatcher = bcodePattern.matcher(bcode);
		
		return bcodeMatcher.matches();
	}
	
	public boolean isValidTitle(String title) {
		Pattern titlePattern = Pattern.compile("[A-Z]\\w{3,19}");
		Matcher titleMatcher = titlePattern.matcher(title);
		
		return titleMatcher.matches();
	}
	
	public boolean isValidPrice(double price){
		return price>=5 && price<=5000;
	}
	
	public boolean isValidPublishDate(LocalDate publishDate){
		LocalDate today = LocalDate.now();
		return today.isAfter(publishDate) || today.equals(publishDate);
	}
	
	public boolean isValidBook(Book book) throws BookStoreException{
		boolean flag=false;
		
		List<String> errMsgs = new ArrayList<>();
		
		if(!isValidBcode(book.getBcode()))
			errMsgs.add("bcode should start with a capital alphabet followed by 3 digits");
		
		if(!isValidTitle(book.getTitle()))
			errMsgs.add("Title must start with capital and must be in between 4 to 20 chars in length");
		
		if(!isValidPrice(book.getPrice()))
			errMsgs.add("Price must be between INR.5 and INR.5000");
		
		if(!isValidPublishDate(book.getPublishDate()))
			errMsgs.add("Publish Date should not be a future date");
		
		if(errMsgs.isEmpty())
			flag=true;
		else
			throw new BookStoreException(errMsgs.toString());
		
		return flag;
	}


	@Override
	public String add(Book book) throws BookStoreException {
		String bcode=null;
		if(book!=null && isValidBook(book)){
			bcode=bookDao.add(book);
		}
		return bcode;
	}

	@Override
	public boolean delete(String bcode) throws BookStoreException {
		boolean flag=false;
		if(bcode!=null && isValidBcode(bcode)){
			bookDao.delete(bcode);
			flag = true;
		} else{
			throw new BookStoreException("bcode should be a capital letter followed by 3 digits");
		}
		return flag;
	}

	@Override
	public Book get(String bcode) throws BookStoreException {
		return bookDao.get(bcode);
	}

	@Override
	public List<Book> getAll() throws BookStoreException {
		return bookDao.getAll();
	}

	@Override
	public boolean update(Book book) throws BookStoreException {
		boolean flag = false;
		
		if(book!=null && isValidBook(book)){
			flag = bookDao.update(book);
		}
		
		return flag;
	}
	
}