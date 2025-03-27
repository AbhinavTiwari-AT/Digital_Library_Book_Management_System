package com.abhinav.digital_library.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhinav.digital_library.Entities.Book;
import com.abhinav.digital_library.Services.BookService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	 @Autowired
	 private ApplicationContext context;

	
	//add books
	@PostMapping
	public ResponseEntity<Book> addBook(@Valid @RequestBody Book book)
	{
	      Book added = bookService.addBook(book);
	      return new ResponseEntity<>(added,HttpStatus.OK);
	}
	
	//get all books
	@GetMapping
	public ResponseEntity<List<Book>> getAllBook()
	{
		List<Book> book = bookService.getAllBooks();
		return new ResponseEntity<>(book,HttpStatus.FOUND);
	}
	
	//get books by Book Id
	@GetMapping("/{bookId}")
	public ResponseEntity<Book> getBookById(@PathVariable String bookId)
	{
		Book book = bookService.getBookById(bookId);
		return new ResponseEntity<>(book,HttpStatus.FOUND);
	}
	
	//get books by Title
	@GetMapping("/title/{title}")
	public ResponseEntity<Book> getBookByTitle(@PathVariable String title)
	{
		Book book = bookService.getBookByTitle(title);
		return new ResponseEntity<>(book,HttpStatus.FOUND);
	}
	
	//update books
	@PutMapping("/{bookId}")
	public ResponseEntity<Book> updateBook(@Valid @PathVariable String bookId, @RequestBody Book book)
	{
		Book update = bookService.updateBook(bookId, book);
		return new ResponseEntity<>(update,HttpStatus.OK);
	}
	
	//delete books
	@DeleteMapping("/{bookId}")
	public ResponseEntity<String> deleteBook(@PathVariable String bookId)
	{
		bookService.deleteBook(bookId);
		return ResponseEntity.ok("Book deleted sucessfully!!");
	}
	
	
	 // exit system 
	 @PostMapping("/exit")
	 public ResponseEntity<String> shutdownApplication() {
	      Thread thread = new Thread(() -> {
	        try {
	              Thread.sleep(2000);
	              System.exit(0);
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	            }
	       });
	       thread.start();
	       return ResponseEntity.ok("The Program is closed....");
	 }
}
