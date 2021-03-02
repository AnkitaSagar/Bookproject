package com.cg.bm.model;

import java.time.LocalDate;
import java.io.Serializable;

public class Book implements Serializable, Comparable<Book>{
	
	private static final long serialVersionUID = 1L;
	
	private String bcode;
	private String title;
	private LocalDate publishDate;
	private double price;
	
	public Book() {
		
	}

	public Book(String bcode, String title, LocalDate publishDate, double price) {
		super();
		this.bcode = bcode;
		this.title = title;
		this.publishDate = publishDate;
		this.price = price;
	}

	public String getBcode() {
		return bcode;
	}

	public void setBcode(String bcode) {
		this.bcode = bcode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("Book code : ");
		result.append(bcode);
		result.append("\t Title : ");
		result.append(title);
		result.append("\t Publish Date : ");
		result.append(publishDate);
		result.append("\t Price : ");
		result.append(price);
		return result.toString();
		
	}
	
	@Override
	public int compareTo(Book book) {
		String firstBCode = this.bcode;
		String secondBCode = book.bcode;
		return firstBCode.compareTo(secondBCode);
	}
		
	@Override
	public int hashCode() {
		int hashCode =0;

		char[] chars = bcode.toCharArray();
		for(int i=1;i<=chars.length;i++){
			hashCode += ((int)chars[i-1])*i;
		}
		
		return hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		boolean flag = false;

		if (obj instanceof Book) {
			Book book = (Book)obj;
			String firstBCode = this.bcode;
			String secondBCode = book.bcode;
			flag= firstBCode.equals(secondBCode);
		}
		
		return flag;		
	}
	

}