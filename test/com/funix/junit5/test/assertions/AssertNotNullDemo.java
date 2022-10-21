package com.funix.junit5.test.assertions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.funix.junit5.model.Book;
import com.funix.junit5.service.BookService;

class AssertNotNullDemo {

	@Test
	void assertNotNullWithNoMessage() {
		BookService bookService = new BookService();
		
		Book headFirtsJavaBook = new Book("1", "Head Firts Java", "Wrox");
		Book headFirtsDesignPatternBook = new Book("2", "Head Firts Design Pattern Book", "Wrox");
	
		bookService.addBook(headFirtsJavaBook);
		bookService.addBook(headFirtsDesignPatternBook);
	
		Book actualBoook = bookService.getBookById("1");
		assertNotNull(actualBoook);
	}


	@Test
	void assertNotNullWithMessage() {
		BookService bookService = new BookService();
		
		Book headFirtsJavaBook = new Book("1", "Head Firts Java", "Wrox");
		Book headFirtsDesignPatternBook = new Book("2", "Head Firts Design Pattern Book", "Wrox");
	
		bookService.addBook(headFirtsJavaBook);
		bookService.addBook(headFirtsDesignPatternBook);
	
		Book actualBoook = bookService.getBookById("1");
		assertNotNull(actualBoook, "Book is null!");
	}

	@Test
	void assertNotNullWithSupplier() {
		BookService bookService = new BookService();
		
		Book headFirtsJavaBook = new Book("1", "Head Firts Java", "Wrox");
		Book headFirtsDesignPatternBook = new Book("2", "Head Firts Design Pattern Book", "Wrox");
	
		bookService.addBook(headFirtsJavaBook);
		bookService.addBook(headFirtsDesignPatternBook);
	
		Book actualBoook = bookService.getBookById("1");
		assertNotNull(actualBoook, () -> "Book is null!");
	}
}
