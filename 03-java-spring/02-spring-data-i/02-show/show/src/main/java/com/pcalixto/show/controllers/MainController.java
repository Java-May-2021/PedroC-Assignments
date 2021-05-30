package com.pcalixto.show.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pcalixto.show.models.Book;
import com.pcalixto.show.services.BookService;

@RestController
public class MainController {
    private final BookService bookService;
    
    public MainController (BookService bookService){
        this.bookService = bookService;
    }
    @RequestMapping("/api/books")
    public List<Book> index() {
        return bookService.allBooks();
    }
    
    @RequestMapping(value="/api/books/add", method=RequestMethod.POST)
    public Book create(@RequestParam(value="title") String title, 
    				   @RequestParam(value="description") String desc, 
    				   @RequestParam(value="language") String lang, 
    				   @RequestParam(value="pages") Integer numOfPages) {
        Book book = new Book(title, desc, lang, numOfPages);
        return bookService.createBook(book);
    }
    
    // @GetMapping("/books/{id}")
    // public Book show(@PathVariable("id") Long id) {
    //     Book book = bookService.findBook(id);
    //     return book;
    // }
    
}
