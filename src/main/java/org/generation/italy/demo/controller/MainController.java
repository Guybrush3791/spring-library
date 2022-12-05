package org.generation.italy.demo.controller;

import java.util.List;
import java.util.Optional;

import org.generation.italy.demo.pojo.Book;
import org.generation.italy.demo.serv.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class MainController {

	@Autowired
	private BookService bookService;
	
	@GetMapping
	public String getBooks(Model model) {
		
		List<Book> books = bookService.findAll();
		model.addAttribute("books", books);
		
		return "books";
	}
	
	@GetMapping("/book/{id}")
	public String getBook(@PathVariable("id") int id, Model model) {
		
		Optional<Book> optBook = bookService.findBookById(id);
		
		if (optBook.isEmpty()) {
			
			System.err.println("Book non presente con id: " + id);
		}
		
		Book book = optBook.get();
		
		model.addAttribute("book", book);
		
		return "book";
	}
	
	@GetMapping("/book/create")
	public String createBook(Model model) {
		
		Book book = new Book();
		model.addAttribute("book", book);
		
		return "book-create";
	}
	@PostMapping("/book/create")
	public String storeBook(@Valid @ModelAttribute("book") Book book) {
		
		bookService.save(book);
		
		return "redirect:/";
	}
	
	@GetMapping("/book/update/{id}")
	public String editBook(@PathVariable("id") int id, Model model) {
		
		Optional<Book> optBook = bookService.findBookById(id);
		Book book = optBook.get();
		
		model.addAttribute("book", book);
		
		return "book-update";
	}
	@PostMapping("/book/store")
	public String updateBook(@Valid Book book) {
		
		bookService.save(book);		
		
		return "redirect:/";
	}
	@GetMapping("/book/delete/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		
		Optional<Book> optBook = bookService.findBookById(id);
		Book book = optBook.get();
		
		bookService.delete(book);
		
		return "redirect:/";
	}
}









