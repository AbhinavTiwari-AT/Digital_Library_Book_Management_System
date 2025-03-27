package com.abhinav.digital_library.Services.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.abhinav.digital_library.Entities.Book;
import com.abhinav.digital_library.Exceptions.ResourceNotFoundException;
import com.abhinav.digital_library.Services.BookService;

@Service
public class BookServiceImpl implements BookService{
	
	//To store the Books data in Collections
	private final List<Book> books = new ArrayList<>();

	@Override
	public Book addBook(Book book) {
		
		// generating book id unique and randomlly
       String bookId = UUID.randomUUID().toString();
                       book.setBookId(bookId);
         //adding book        
        books.add(book);
		return book;
	}

	@Override
	public List<Book> getAllBooks() {

		return books;
	}

	@Override
	public Book getBookById(String bookId) {

		Book book = books.stream().filter(b -> b.getBookId().equals(bookId))
				         .findFirst()
				         .orElseThrow(()-> new ResourceNotFoundException("Book","BookId", bookId));
		return book;
	}

	@Override
	public Book getBookByTitle(String title) {

		Book book = books.stream().filter(b -> b.getTitle().equalsIgnoreCase(title))
				         .findFirst()
				         .orElseThrow(() -> new ResourceNotFoundException("Book","tille",title));
		return book;
	}

	@Override
	public Book updateBook(String bookId, Book updateBook) {
		
		Book book  = getBookById(bookId);
	    book.setTitle(updateBook.getTitle());
	    book.setAuthor(updateBook.getAuthor());
	    book.setGenre(updateBook.getGenre());
	    book.setStatus(updateBook.getStatus());
		return book;
	}

	@Override
	public void deleteBook(String bookId) {
		
		Book book  = getBookById(bookId);
		             books.remove(book);
	}

}
