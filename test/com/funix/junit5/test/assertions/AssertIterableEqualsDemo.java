package com.funix.junit5.test.assertions;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.funix.junit5.model.Book;
import com.funix.junit5.service.BookService;

class AssertIterableEqualsDemo {

	@Test
	void assertIterableEqualsWithNoMessage() {
		BookService bookService = new BookService();

		Book headFirtsJavaBook = new Book("1", "Head Firts Java", "Wrox");
		Book headFirtsDesignPatternBook = new Book("2", "Head Firts Design Pattern Book", "Wrox");
		Book headFirtsJavaScriptBook = new Book("3", "Head Firts JavaScript Book", "Wrox");

		bookService.addBook(headFirtsJavaBook);
		bookService.addBook(headFirtsDesignPatternBook);
		bookService.addBook(headFirtsJavaScriptBook);

		List<String> acctualTitles = bookService.getBookTitlesByPublisher("Wrox");

		List<String> expectedTitles = new ArrayList<>();
		expectedTitles.add("Head Firts Java");
		expectedTitles.add("Head Firts JavaScript Book");

		assertIterableEquals(expectedTitles, acctualTitles);
	}

	@Test
	void assertIterableEqualsWithMessage() {
		BookService bookService = new BookService();

		Book headFirtsJavaBook = new Book("1", "Head Firts Java", "Wrox");
		Book headFirtsDesignPatternBook = new Book("2", "Head Firts Design Pattern Book", "Wrox");
		Book headFirtsJavaScriptBook = new Book("3", "Head Firts JavaScript Book", "Wrox");

		bookService.addBook(headFirtsJavaBook);
		bookService.addBook(headFirtsDesignPatternBook);
		bookService.addBook(headFirtsJavaScriptBook);

		List<String> actualTitles = bookService.getBookTitlesByPublisher("Wrox");

		List<String> expectedTitles = new ArrayList<>();
		expectedTitles.add("Head Firts Java");
		expectedTitles.add("Head Firts JavaScript Book");
		expectedTitles.add("Head Firts Design Pattern Book");

		assertIterableEquals(expectedTitles, actualTitles, "Book Titles didn't match!");
	}

	@Test
	void assertIterableEqualsWithMessageSupplier() {
		BookService bookService = new BookService();

		Book headFirtsJavaBook = new Book("1", "Head Firts Java", "Wrox");
		Book headFirtsDesignPatternBook = new Book("2", "Head Firts Design Pattern Book", "Wrox");
		Book headFirtsJavaScriptBook = new Book("3", "Head Firts JavaScript Book", "Wrox");

		bookService.addBook(headFirtsJavaBook);
		bookService.addBook(headFirtsDesignPatternBook);
		bookService.addBook(headFirtsJavaScriptBook);

		List<String> actualTitles = bookService.getBookTitlesByPublisher("Wrox");

		List<String> expectedTitles = new ArrayList<>();
		expectedTitles.add("Head Firts Java");
		expectedTitles.add("Head Firts JavaScript Book");
		expectedTitles.add("Head Firts Design Pattern Book");

		assertIterableEquals(expectedTitles, actualTitles, () -> "Book Titles didn't match!");
	}

}
