package com.funix.junit5.test.assertions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.funix.junit5.model.Book;
import com.funix.junit5.service.BookService;

class AssertNotEqualsDemo {

	@Test
	void assertEqualsWithNoMessage() {
		BookService bookService = new BookService();
		
		Book headFirtsJavaBook = new Book("1", "Head Firts Java", "Wrox");
		Book headFirtsDesignPatternBook = new Book("2", "Head Firts Design Pattern Book", "Wrox");
	
		bookService.addBook(headFirtsJavaBook);
		bookService.addBook(headFirtsDesignPatternBook);
	
		Book actualBoook = bookService.getBookById("1");
		assertEquals("1", actualBoook.getBookId());
		assertEquals("Head Firts", actualBoook.getTitle());
	}


	@Test
	void assertEqualsWithMessage() {
		BookService bookService = new BookService();
		
		Book headFirtsJavaBook = new Book("1", "Head Firts Java", "Wrox");
		Book headFirtsDesignPatternBook = new Book("2", "Head Firts Design Pattern Book", "Wrox");
	
		bookService.addBook(headFirtsJavaBook);
		bookService.addBook(headFirtsDesignPatternBook);
	
		Book actualBoook = bookService.getBookById("1");
		assertEquals("1", actualBoook.getBookId());
		assertEquals("Head Firts", actualBoook.getTitle(), "Book title didn't match");
	}

	@Test
	void assertEqualsWithMessageSupplier() {
		BookService bookService = new BookService();
		
		Book headFirtsJavaBook = new Book("1", "Head Firts Java", "Wrox");
		Book headFirtsDesignPatternBook = new Book("2", "Head Firts Design Pattern Book", "Wrox");
	
		bookService.addBook(headFirtsJavaBook);
		bookService.addBook(headFirtsDesignPatternBook);
	
		Book actualBoook = bookService.getBookById("1");
		
		assertEquals("1", actualBoook.getBookId());
		assertEquals("Head Firts Java", actualBoook.getTitle(), () -> "Book title didn't match");
	} 

}
