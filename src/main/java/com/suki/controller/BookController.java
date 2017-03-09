package com.suki.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.suki.model.Book;
import com.suki.model.BookRepository;



@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@RequestMapping(value= "/")
	public String blank(){
	return "redirect:/booklist";
	}
	
	@RequestMapping(value= "/login")
	public String login(){
	return "/login";
	}
	
	@RequestMapping(value = "/addbook", method = RequestMethod.GET)
	public String addBook(Model model) {
		
		model.addAttribute("book", new Book());	
	
	return "addbook";
	}
	
	// RESTful service to get all books
    @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {	
        return (List<Book>) repository.findAll();
    }   
    
	// RESTful service to get book by id
    @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
    public @ResponseBody Book findBookRest(@PathVariable("id") Long bookId) {	
    	return repository.findOne(bookId);
    }  
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveBook(Book book, Model model) {
		System.out.println(book);
	repository.save(book);
	return "redirect:/booklist";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") long bookId, Model model) {
	repository.delete(bookId);
	return "redirect:../booklist";
	}

	@RequestMapping(value="/booklist", method=RequestMethod.GET)
	public String bookstore(Model model) {
		
		model.addAttribute("books", repository.findAll());

		return "booklist";
	}

}
