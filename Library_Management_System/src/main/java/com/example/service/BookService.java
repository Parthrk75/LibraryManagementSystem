package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Book;
import com.example.entity.User;
import com.example.repositories.BookRepository;
import com.example.repositories.UserRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private UserRepository userRepository ;

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	public Book getSingleBook(long id) {
		// TODO Auto-generated method stub
		return bookRepository.findById(id).orElse(null);
	}

	public Book addbook(Book book) {
		// TODO Auto-generated method stub
		return bookRepository.save(book);
	}

	public String updateBook(Book book) {
		if(bookRepository.existsById(book.getId())) {
			bookRepository.save(book);
			return "Book updated successfully";
		}else {
			
			return "Book not found";
		}
		
	}

	public String deleteBook(Long id) {
		if(bookRepository.existsById(id)) {
			bookRepository.deleteById(id);
			return "Book deleted successfully";
		}else {
			
			return "Book not found";
		}
	}

	public Book borrowBook(Long bookId, long userId) {
		// TODO Auto-generated method stub
		Book book = bookRepository.findById(bookId).orElse(null);
		User user = userRepository.findById(userId).orElse(null);
		
		if(book !=null && !book.isBorrowed() && user != null) {
			book.setBorrowedBy(user);
			book.setBorrowed(true);
			return bookRepository.save(book);
		}
		return null;
	}

	public Book returnBook(Long bookId) {
		// TODO Auto-generated method stub
		Book book = bookRepository.findById(bookId).orElse(null);
		if (book != null && book.isBorrowed()) {
            book.setBorrowedBy(null);
            book.setBorrowed(false);
            return bookRepository.save(book);
        }
		return null;
	}

	
	
	

	
	
	

}
