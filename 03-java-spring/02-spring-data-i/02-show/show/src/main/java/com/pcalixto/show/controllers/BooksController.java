package com.pcalixto.show.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pcalixto.show.models.Book;
import com.pcalixto.show.services.BookService;

@Controller
public class BooksController {
    private final BookService bookService;
    
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @RequestMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "index.jsp";
    }
    
    @RequestMapping("/books/{id}")
    public String findBookById(Model model, @PathVariable("id") Long id) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "showBook.jsp";
    }
    
    @RequestMapping("/book/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "/newBook.jsp";
    }
    
    @RequestMapping(value="/book/add", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/newBook.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
    }

    @DeleteMapping("/books/{id}")
    public String delete(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    	return "redirect:/books";
    }    
}