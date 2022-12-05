package org.generation.italy.demo.serv;

import java.util.List;
import java.util.Optional;

import org.generation.italy.demo.pojo.Book;
import org.generation.italy.demo.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	@Autowired
	private BookRepo bookRepo;
	
	public void save(Book book) {
		
		bookRepo.save(book);
	}
	public List<Book> findAll() {
		
		return bookRepo.findAll();
	}
	public Optional<Book> findBookById(int id) {
		
		return bookRepo.findById(id);
	}
	public void delete(Book book) {
		
		bookRepo.delete(book);
	}
	public void deleteById(int id) {
		
		bookRepo.deleteById(id);
	}
}
