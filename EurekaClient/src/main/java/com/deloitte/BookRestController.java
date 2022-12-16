package com.deloitte;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")

public class BookRestController {
	
	@Autowired
	Environment environment;
	
	@GetMapping("/data")
	public String getBookData() {
		
		return "data of Book-Service,running on port: "+environment.getProperty("local.server.port");
	}
	
	@GetMapping("/{id}")
		public Book getBookById(@PathVariable Integer id) {
			return new Book(id, "Head First Java", 575.09);
		}
		
	@GetMapping("/allBooks")
	public List<Book> getAllBooks(){
		return List.of(
				
				new Book(101,"head First Java", 440.34),
				new Book(102, "The Complete Refrence", 740.34),
				new Book(103, "Kathy sierra Book", 970.34)
				);
			}
	
	
	@GetMapping("/entity")
	public ResponseEntity<String> getEntityData(){
		return new ResponseEntity<String>("Hello from Book", HttpStatus.OK);
	}
	
}
	
