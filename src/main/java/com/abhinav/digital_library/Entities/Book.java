package com.abhinav.digital_library.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	
private String bookId;
	
	private String title;
	
	private String author;
	
	private String genre;
	
	private BookStatus status;

}
