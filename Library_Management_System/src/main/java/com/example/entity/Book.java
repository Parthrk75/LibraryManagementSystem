package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private boolean borrowed;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User borrowedBy;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(Long id, String title, String author, boolean borrowed, User borrowedBy) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.borrowed = borrowed;
		this.borrowedBy = borrowedBy;
	}
	public Book(String title, String author, boolean borrowed, User borrowedBy) {
		super();
		this.title = title;
		this.author = author;
		this.borrowed = borrowed;
		this.borrowedBy = borrowedBy;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public boolean isBorrowed() {
		return borrowed;
	}
	public void setBorrowed(boolean borrowed) {
		this.borrowed = borrowed;
	}
	public User getBorrowedBy() {
		return borrowedBy;
	}
	public void setBorrowedBy(User borrowedBy) {
		this.borrowedBy = borrowedBy;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", borrowed=" + borrowed + ", borrowedBy="
				+ borrowedBy + "]";
	}
    
    
}
