package com.funix.junit5.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.funix.junit5.exception.BookNotFoundException;
import com.funix.junit5.model.Book;

public class BookService {
	
	private List<Book> listOfBooks = new ArrayList<>();
	
	public void addBook(Book book) {
		listOfBooks.add(book);
	}

	public List<Book> books() {
		return Collections.unmodifiableList(listOfBooks);
	}
	
	public Book getBookById(String bookId) {
		for (Book book : listOfBooks) {
			if (bookId.equals(book.getBookId())) {
				return book;
			}
		}
		return null;
	}
	
	public String[]	getBookIdByPublisher(String publisher) {
		List<String> bookIds = new ArrayList<String>();
		for (Book book : listOfBooks) {
			if (publisher.equals(book.getPublisher())) {
				bookIds.add(book.getBookId());				
			}
		}
		return bookIds.toArray(new String[bookIds.size()]);
	}

	public List<String>	getBookTitlesByPublisher(String publisher) {
		List<String> bookTitles = new ArrayList<>();
		for (Book book : listOfBooks) {
			if (publisher.equals(book.getPublisher())) {
				bookTitles.add(book.getBookId());				
			}
		}
		return bookTitles;
	}
	
	public Book getBookByTitle(String title) {
		for (Book book : listOfBooks) {
			if (title.equals(book.getTitle())) {
				return book;
			}
		}
		throw new BookNotFoundException("Book not fount in Bookstore!");
	}
}
