package com.funix.junit5.test.assertions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.funix.junit5.model.Book;
import com.funix.junit5.service.BookService;

class AssertArraysEqualsDemo {

	@Test
	void assertArraysEqualsWithNoMessage() {
		BookService bookService = new BookService();

		Book headFirtsJavaBook = new Book("1", "Head Firts Java", "Wrox");
		Book headFirtsDesignPatternBook = new Book("2", "Head Firts Design Pattern Book", "Wrox");
		Book headFirtsJavaScriptBook = new Book("3", "Head Firts JavaScript Book", "Wrox");

		bookService.addBook(headFirtsJavaBook);
		bookService.addBook(headFirtsDesignPatternBook);
		bookService.addBook(headFirtsJavaScriptBook);

		String[] actualBookIds = bookService.getBookIdByPublisher("Wrox");

		assertArrayEquals(new String[] { "3", "1" }, actualBookIds);
	}

	@Test
	void assertArraysEqualsWithMessage() {
		BookService bookService = new BookService();

		Book headFirtsJavaBook = new Book("1", "Head Firts Java", "Wrox");
		Book headFirtsDesignPatternBook = new Book("2", "Head Firts Design Pattern Book", "Wrox");
		Book headFirtsJavaScriptBook = new Book("3", "Head Firts JavaScript Book", "Wrox");

		bookService.addBook(headFirtsJavaBook);
		bookService.addBook(headFirtsDesignPatternBook);
		bookService.addBook(headFirtsJavaScriptBook);

		String[] actualBookIds = bookService.getBookIdByPublisher("Wrox");

		assertArrayEquals(new String[] { "3", "1" }, actualBookIds, "BookIds didn't match!");
	}

	@Test
	void assertArraysEqualsWithMessageSupplier() {
		BookService bookService = new BookService();

		Book headFirtsJavaBook = new Book("1", "Head Firts Java", "Wrox");
		Book headFirtsDesignPatternBook = new Book("2", "Head Firts Design Pattern Book", "Wrox");
		Book headFirtsJavaScriptBook = new Book("3", "Head Firts JavaScript Book", "Wrox");

		bookService.addBook(headFirtsJavaBook);
		bookService.addBook(headFirtsDesignPatternBook);
		bookService.addBook(headFirtsJavaScriptBook);

		String[] actualBookIds = bookService.getBookIdByPublisher("Wrox");

		assertArrayEquals(new String[] { "3", "1" }, actualBookIds, () -> "BookIds didn't match!");
	}

}
