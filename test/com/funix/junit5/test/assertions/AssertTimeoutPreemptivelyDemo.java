package com.funix.junit5.test.assertions;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.funix.junit5.model.Book;
import com.funix.junit5.service.BookService;

class AssertTimeoutPreemptivelyDemo {

	@Test
	void assertTimeoutPreemptivelyWithNoMessage() {
		BookService bookService = new BookService();

		for (int i = 1; i <= 10000; i++) {
			bookService.addBook(new Book(String.valueOf(i), "Head Firts Java", "Wrox"));
		}

		List<String> actualTitles = new ArrayList<>();
		assertTimeoutPreemptively(Duration.ofMillis(1), () -> {
			actualTitles.addAll(bookService.getBookTitlesByPublisher("Wrox"));
		});

		assertEquals(10000, actualTitles.size());
	}

	@Test
	void assertTimeoutPreemptivelyWithMessage() {
		BookService bookService = new BookService();

		for (int i = 1; i <= 10000; i++) {
			bookService.addBook(new Book(String.valueOf(i), "Head Firts Java", "Wrox"));
		}

		List<String> actualTitles = new ArrayList<>();
		assertTimeoutPreemptively(Duration.ofMillis(1), () -> {
			actualTitles.addAll(bookService.getBookTitlesByPublisher("Wrox"));
		}, "Performance issues with getBookTitlesByPublisher() method!");

		assertEquals(10000, actualTitles.size());
	}
	
	@Test
	void assertTimeoutPreemptivelyWithMessageSupplier() {
		BookService bookService = new BookService();

		for (int i = 1; i <= 1000; i++) {
			bookService.addBook(new Book(String.valueOf(i), "Head Firts Java", "Wrox"));
		}

		List<String> actualTitles = new ArrayList<>();
		assertTimeoutPreemptively(Duration.ofMillis(1), () -> {
			actualTitles.addAll(bookService.getBookTitlesByPublisher("Wrox"));
		}, () -> "Performance issues with getBookTitlesByPublisher() method!");

		assertEquals(1000, actualTitles.size());
	}
}
