package com.funix.junit5.test.assertions;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.funix.junit5.model.Book;
import com.funix.junit5.service.BookService;

class AssertNullDemo {

	@Test
	void assertNullWithNoMessage() {
		BookService bookService = new BookService();
		
		Book headFirtsJavaBook = new Book("1", "Head Firts Java", "Wrox");
		Book headFirtsDesignPatternBook = new Book("2", "Head Firts Design Pattern Book", "Wrox");
	
		bookService.addBook(headFirtsJavaBook);
		bookService.addBook(headFirtsDesignPatternBook);
	
		Book actualBoook = bookService.getBookById("1");
		assertNull(actualBoook);
	}
	
	@Test
	void assertNullWithMessage() {
		BookService bookService = new BookService();
		
		Book headFirtsJavaBook = new Book("1", "Head Firts Java", "Wrox");
		Book headFirtsDesignPatternBook = new Book("2", "Head Firts Design Pattern Book", "Wrox");
	
		bookService.addBook(headFirtsJavaBook);
		bookService.addBook(headFirtsDesignPatternBook);
	
		Book actualBoook = bookService.getBookById("1");
		assertNull(actualBoook, "Book is not null!");
	}

	@Test
	void assertNullWithSupplier() {
		BookService bookService = new BookService();
		
		Book headFirtsJavaBook = new Book("1", "Head Firts Java", "Wrox");
		Book headFirtsDesignPatternBook = new Book("2", "Head Firts Design Pattern Book", "Wrox");
	
		bookService.addBook(headFirtsJavaBook);
		bookService.addBook(headFirtsDesignPatternBook);
	
		Book actualBoook = bookService.getBookById("1");
		assertNull(actualBoook, () -> "Book is not null!");
	}
}
