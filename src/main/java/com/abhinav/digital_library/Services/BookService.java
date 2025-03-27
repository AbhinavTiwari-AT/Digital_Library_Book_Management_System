package com.abhinav.digital_library.Services;

import java.util.List;

import com.abhinav.digital_library.Entities.Book;

public interface BookService {
	
	    Book addBook(Book book); // Add book
	    
	    List<Book> getAllBooks(); //Get all books
	    
	    Book getBookById(String bookId); //Get book by ID
	    
	    Book getBookByTitle(String title); //Get book by title
	        
	    Book updateBook(String bookId, Book book); //Update book details
	    
	    void deleteBook(String bookId); //Delete a book

}
