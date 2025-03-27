package com.abhinav.digital_library.BookServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.abhinav.digital_library.Entities.Book;
import com.abhinav.digital_library.Entities.BookStatus;
import com.abhinav.digital_library.Services.Impl.BookServiceImpl;

class BookServiceImplTest {

    private static final Logger logger = LoggerFactory.getLogger(BookServiceImplTest.class);

    private BookServiceImpl bookService;
    
    private List<Book> books;

    @BeforeEach
    void setUp() {
        bookService = new BookServiceImpl();
        books = new ArrayList<>();
        logger.info("Test Setup Completed");
    }

    //Test Case: Add Book
    @Test
    void testAddBook() {
        Book book = new Book(UUID.randomUUID().toString(), "Spring Boot", "Pivotal", "Tech", BookStatus.AVAILABLE);
        Book savedBook = bookService.addBook(book);

        assertNotNull(savedBook);
        assertEquals("Spring Boot", savedBook.getTitle());

        logger.info("Added Book: {}", savedBook);
    }

    //Test Case: Get All Books
    @Test
    void testGetAllBooks() {
        Book book1 = new Book(UUID.randomUUID().toString(), "Java Basics", "James Gosling", "Programming", BookStatus.AVAILABLE);
        Book book2 = new Book(UUID.randomUUID().toString(), "Spring Boot", "Pivotal", "Tech", BookStatus.CHECKED_OUT);
        
        bookService.addBook(book1);
        bookService.addBook(book2);

        List<Book> fetchedBooks = bookService.getAllBooks();

        assertEquals(2, fetchedBooks.size());
        logger.info("All Books: {}", fetchedBooks);
    }

    //Test Case: Get Book by ID
    @Test
    void testGetBookById() {
        Book book = new Book(UUID.randomUUID().toString(), "ReactJS", "Facebook", "Frontend", BookStatus.AVAILABLE);
        bookService.addBook(book);
        
        Book fetchedBook = bookService.getBookById(book.getBookId());

        assertNotNull(fetchedBook);
        assertEquals("ReactJS", fetchedBook.getTitle());

        logger.info("Fetched Book by ID: {}", fetchedBook);
    }

    //Test Case: Get Book by Title
    @Test
    void testGetBookByTitle() {
        Book book = new Book(UUID.randomUUID().toString(), "Python Basics", "Guido van Rossum", "Programming", BookStatus.AVAILABLE);
        bookService.addBook(book);

        Book fetchedBook = bookService.getBookByTitle("Python Basics");

        assertNotNull(fetchedBook);
        assertEquals("Python Basics", fetchedBook.getTitle());

        logger.info("Fetched Book by Title: {}", fetchedBook);
    }

    //Test Case: Update Book
    @Test
    void testUpdateBook() {
        Book book = new Book(UUID.randomUUID().toString(), "C++ Basics", "Bjarne Stroustrup", "Programming", BookStatus.AVAILABLE);
        bookService.addBook(book);

        Book updatedBook = new Book(book.getBookId(), "C++ Advanced", "Bjarne Stroustrup", "Programming", BookStatus.CHECKED_OUT);
        Book result = bookService.updateBook(book.getBookId(), updatedBook);

        assertNotNull(result);
        assertEquals("C++ Advanced", result.getTitle());

        logger.info("Updated Book: {}", result);
    }

    //Test Case: Delete Book
    @Test
    void testDeleteBook() {
        Book book = new Book(UUID.randomUUID().toString(), "Java EE", "Oracle", "Enterprise", BookStatus.AVAILABLE);
        bookService.addBook(book);

        bookService.deleteBook(book.getBookId());

        List<Book> fetchedBooks = bookService.getAllBooks();
        assertEquals(0, fetchedBooks.size());

        logger.info("Books after Deletion: {}", fetchedBooks);
    }
}
