package org.generation.italy.demo;

import java.util.List;

import org.generation.italy.demo.pojo.Book;
import org.generation.italy.demo.serv.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLibraryLcApplication implements CommandLineRunner {

	@Autowired
	private BookService bookService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringLibraryLcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// INSERIMENTO
		
		Book b1 = new Book("1234567891234", "Moby Dick", 1930, 30000);
		Book b2 = new Book("1234567891235", "Topolino", 1945, 70000);
		Book b3 = new Book("1234567891236", "Paperino", 1810, 24500);
		Book b4 = new Book("1234567891237", "Pluto", 1718, 500000);
		
		bookService.save(b1);
		bookService.save(b2);
		bookService.save(b3);
		bookService.save(b4);
		
		// LETTURA
		
		List<Book> books = bookService.findAll();
		System.out.println(books);
	}
}
