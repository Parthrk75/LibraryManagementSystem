package com.example.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.entity.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}