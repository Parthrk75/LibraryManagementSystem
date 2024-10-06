package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Book;
import com.example.service.BookService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/books")
public class BookController {
	
	@Autowired
	 private BookService bookService;
	
	@GetMapping("/")
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	@GetMapping("/{id}")
	public Book getSingleBook(@PathVariable Long id) {
		return bookService.getSingleBook(id);
	}
	
	@PostMapping("/addbook")
	public Book addBook(@RequestBody Book book) {
		return bookService.addbook(book);
	}
	
	@PutMapping("/updatebook/{id}")
	public String updateBook(@PathVariable long id, @RequestBody Book book) {
		book.setId(id);
		return bookService.updateBook(book);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable Long id) {
		return bookService.deleteBook(id);
	}
	
	@PostMapping("/{bookId}/barrow/{userId}")
	public ResponseEntity<Book> borrowBook(@PathVariable Long bookId, @PathVariable long userId) {
		Book borrowedbook = bookService.borrowBook(bookId,userId);
		if(borrowedbook != null) {
			return ResponseEntity.ok(borrowedbook);
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	@PostMapping("/{bookId}/return")
    public ResponseEntity<Book> returnBook(@PathVariable Long bookId) {
        Book returnedBook = bookService.returnBook(bookId);
        if (returnedBook != null) {
            return ResponseEntity.ok(returnedBook);
        } else {
            return ResponseEntity.badRequest().build(); // or a more descriptive error response
        }
    }

}
