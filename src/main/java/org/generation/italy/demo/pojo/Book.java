package org.generation.italy.demo.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message="isbn must not be null")
	@Size(min=13, max=13, message="isbn must be 13 charachters")
	@Column(name="isbn_code", length=13)
	private String isbn; 
	
	@NotNull
	@NotEmpty(message = "il titolo deve contenere qualcosa")
	@Column(length = 128)
	private String title;
	
	@NotNull
	private int year;
	
	@NotNull
	@Min(value=0)
	private int numberOfCopies;
	
	public Book() { }
	public Book(String isbn, String title, int year, int numberOfCopies) {
		
		setIsbn(isbn);
		setTitle(title);
		setYear(year);
		setNumberOfCopies(numberOfCopies);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getNumberOfCopies() {
		return numberOfCopies;
	}
	public void setNumberOfCopies(int numberOfCopies) {
		this.numberOfCopies = numberOfCopies;
	}
	
	@Override
	public String toString() {
		
		return getId() + " - " + getTitle()
			+ "\nISBN: " + getIsbn()
			+ "\nnumber of copies: " + getNumberOfCopies()
			+ "\nyear: " + getYear();
	}
}
