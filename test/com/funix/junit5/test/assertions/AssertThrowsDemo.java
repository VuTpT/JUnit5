package com.funix.junit5.test.assertions;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.funix.junit5.exception.BookNotFoundException;
import com.funix.junit5.model.Book;
import com.funix.junit5.service.BookService;

class AssertThrowsDemo {

	@Test
	void assertThrowsWithNoMessage() {
		BookService bookService = new BookService();

		Book headFirtsJavaBook = new Book("1", "Head Firts Java", "Wrox");
		Book headFirtsDesignPatternBook = new Book("2", "Head Firts Design Pattern Book", "Wrox");

		bookService.addBook(headFirtsJavaBook);
		bookService.addBook(headFirtsDesignPatternBook);

		assertThrows(BookNotFoundException.class, () -> bookService.getBookByTitle("Head Firts Spring"),
				"Different exception thrown!");
	}

	@Test
	void assertThrowsWithMessage() {
		BookService bookService = new BookService();

		Book headFirtsJavaBook = new Book("1", "Head Firts Java", "Wrox");
		Book headFirtsDesignPatternBook = new Book("2", "Head Firts Design Pattern Book", "Wrox");

		bookService.addBook(headFirtsJavaBook);
		bookService.addBook(headFirtsDesignPatternBook);

		assertThrows(NullPointerException.class, () -> bookService.getBookByTitle("Head Firts Spring"));
	}

	@Test
	void assertThrowsWithMessageSupplier() {
		BookService bookService = new BookService();

		Book headFirtsJavaBook = new Book("1", "Head Firts Java", "Wrox");
		Book headFirtsDesignPatternBook = new Book("2", "Head Firts Design Pattern Book", "Wrox");

		bookService.addBook(headFirtsJavaBook);
		bookService.addBook(headFirtsDesignPatternBook);

		assertThrows(NullPointerException.class, () -> bookService.getBookByTitle("Head Firts Spring"),
				() -> "Different exception thrown!");
	}

}
