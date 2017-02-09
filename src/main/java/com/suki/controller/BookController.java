package com.suki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.suki.model.Book;
import com.suki.model.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@RequestMapping(value = "/addbook", method = RequestMethod.GET)
	public String addBook(Model model) {
		
		model.addAttribute("book", new Book());	
	
	return "addbook";
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
