package com.funix.junit5.test.assertions;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.funix.junit5.model.Book;
import com.funix.junit5.service.BookService;

class AssertFalseDemo {

	@Test
	void assertTrueWithNoMessage() {
		BookService bookService = new BookService();
		
		Book headFirstJavaBook = new Book("1", "Head First Java", "Wrow");
		
		bookService.addBook(headFirstJavaBook);
		
		List<Book> listOfBooks = bookService.books();
	
		assertTrue(listOfBooks.isEmpty());
	}

	@Test
	void assertFalseWithMessage() {
		BookService bookService = new BookService();
		
		Book headFirstJavaBook = new Book("1", "Head First Java", "Wrow");
		
		bookService.addBook(headFirstJavaBook);
		
		List<Book> listOfBooks = bookService.books();
	
		assertFalse(listOfBooks.isEmpty(), "List of books is not empty!");
	}

	@Test
	void assertFalseWithMessageSupplier() {
		BookService bookService = new BookService();
		
		Book headFirstJavaBook = new Book("1", "Head First Java", "Wrow");
		
		bookService.addBook(headFirstJavaBook);
		
		List<Book> listOfBooks = bookService.books();
	
		assertFalse(listOfBooks.isEmpty(), () ->  "List of books is not empty!");
	}
	
	@Test
	void assertFalseWithBooleanSupplierAndNoMessage() {
		BookService bookService = new BookService();
		
		Book headFirstJavaBook = new Book("1", "Head First Java", "Wrow");
		
		bookService.addBook(headFirstJavaBook);
		
		List<Book> listOfBooks = bookService.books();
	
		assertFalse(() -> listOfBooks.isEmpty());
	}
	
	@Test
	void assertFalseWithBooleanSupplierAndMessage() {
		BookService bookService = new BookService();
		
		Book headFirstJavaBook = new Book("1", "Head First Java", "Wrow");
		
		bookService.addBook(headFirstJavaBook);
		
		List<Book> listOfBooks = bookService.books();
	
		assertFalse(() -> listOfBooks.isEmpty(), "List of books is not empty!");
	}
	
	@Test
	void assertFalseWithBooleanSupplirtAndMessageSupplier() {
		BookService bookService = new BookService();
		
		Book headFirstJavaBook = new Book("1", "Head First Java", "Wrow");
		
		bookService.addBook(headFirstJavaBook);
		
		List<Book> listOfBooks = bookService.books();
	
		assertFalse(() -> listOfBooks.isEmpty(), () ->  "List of books is not empty!");
	}
}
