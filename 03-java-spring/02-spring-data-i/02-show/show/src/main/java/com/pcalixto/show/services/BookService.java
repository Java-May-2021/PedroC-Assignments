package com.pcalixto.show.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.pcalixto.show.models.Book;
import com.pcalixto.show.repositories.BookRepository;

@Service
public class BookService {
 // adding the book repository as a dependency
private final BookRepository bookRepository;
 
 public BookService(BookRepository bookRepository) {
     this.bookRepository = bookRepository;
 }
 // returns all the books
 public List<Book> allBooks() {
     return bookRepository.findAll();
 }
 // creates a book
 public Book createBook(Book b) {
     return bookRepository.save(b);
 }
 // updates a book
 public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
	 Book b = bookRepository.findById(id).orElse(null);
	 b.setTitle(title);
	 b.setDescription(desc);
	 b.setLanguage(lang);
	 b.setNumberOfPages(numOfPages);
     return bookRepository.save(b);
 }
 // deletes a book
 public void deleteBook(Long id) {
     bookRepository.deleteById(id);
 }
 // retrieves a book
 public Book findBook(Long id) {
     Optional<Book> optionalBook = bookRepository.findById(id);
     if(optionalBook.isPresent()) {
         return optionalBook.get();
     } else {
         return null;
     }
 }

 public Book findBookAlt(Long id) {
	 return bookRepository.findById(id).orElse(null);
 }

}

