package com.abhinav.digital_library.Entities;

import jakarta.validation.constraints.NotBlank;
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
	
	@NotBlank(message = "Title of Book Cannot be Empty!!")
	private String title;
	
	@NotBlank(message = "Author of Book cannot be Empty!!")
	private String author;
	
	private String genre;
	
	private BookStatus status;

}
