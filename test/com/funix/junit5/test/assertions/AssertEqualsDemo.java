package com.funix.junit5.test.assertions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.funix.junit5.model.Book;
import com.funix.junit5.service.BookService;

class AssertEqualsDemo {

	@Test
	void assertNotEqualsWithNoMessage() {
		BookService bookService = new BookService();
		
		Book headFirtsJavaBook = new Book("1", "Head Firts Java", "Wrox");
		Book headFirtsDesignPatternBook = new Book("2", "Head Firts Design Pattern Book", "Wrox");
	
		bookService.addBook(headFirtsJavaBook);
		bookService.addBook(headFirtsDesignPatternBook);
	
		Book actualBoook = bookService.getBookById("1");
		assertNotEquals("1", actualBoook.getBookId());
		assertNotEquals("Head Firts", actualBoook.getTitle());
	}


	@Test
	void assertNotEqualsWithMessage() {
		BookService bookService = new BookService();
		
		Book headFirtsJavaBook = new Book("1", "Head Firts Java", "Wrox");
		Book headFirtsDesignPatternBook = new Book("2", "Head Firts Design Pattern Book", "Wrox");
	
		bookService.addBook(headFirtsJavaBook);
		bookService.addBook(headFirtsDesignPatternBook);
	
		Book actualBoook = bookService.getBookById("1");
		assertNotEquals("1", actualBoook.getBookId(), "BookId matches to expected value!");
		assertNotEquals("Head Firts", actualBoook.getTitle(), "Book title didn't match");
	}

	@Test
	void assertNotEqualsWithMessageSupplier() {
		BookService bookService = new BookService();
		
		Book headFirtsJavaBook = new Book("1", "Head Firts Java", "Wrox");
		Book headFirtsDesignPatternBook = new Book("2", "Head Firts Design Pattern Book", "Wrox");
	
		bookService.addBook(headFirtsJavaBook);
		bookService.addBook(headFirtsDesignPatternBook);
	
		Book actualBoook = bookService.getBookById("1");
		
		assertNotEquals("1", actualBoook.getBookId());
		assertNotEquals("Head Firts Java", actualBoook.getTitle(), () -> "Book title didn't match");
	} 

}
