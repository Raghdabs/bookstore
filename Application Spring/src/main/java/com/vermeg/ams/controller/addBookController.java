package com.vermeg.ams.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vermeg.ams.entities.Book;
import com.vermeg.ams.repositories.BookRepository;

@Controller
@RequestMapping(value = "pages")
public class addBookController {

    @GetMapping(value = "listBook")
    public String mmDashboard(Model model) {
    	return "redirect:list";
    }
   
	private final BookRepository bookRepository;

	@Autowired // IOC
	public addBookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	
	  @GetMapping("list") // @ResponseBody 
	  public String listProviders(Model model)
	  {
	  
	  List<Book> lp = (List<Book>) bookRepository.findAll();
	  
	  if (lp.size() == 0) { lp = null; } model.addAttribute("books", lp);
	  
	  return "pages/listBook"; 
	  // System.out.println(lp);
	  
	  // return "Nombre de fournisseur = " + lp.size(); }
	  }

	@GetMapping("add")
	public String showAddProviderForm(Model model) {
		Book book = new Book();// object dont la valeur des attributs par defaut
		model.addAttribute("book", book);
		return "pages/addBook";
	}

	@PostMapping("add")
	public String addProvider(@Valid Book book, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "pages/addBook";
		}
		bookRepository.save(book);
		return "redirect:list";
	}

	
	  @GetMapping("delete/{id}") 
	  public String deleteBook(@PathVariable("id") int id, Model model) {
	  
	  // long id2 = 100L;
	  
	  Book book = bookRepository.findById(id) .orElseThrow(() -> new
	  IllegalArgumentException("Invalid book Id:" + id));
	  
	  //System.out.println("suite du programme...");
	  
	  bookRepository.delete(book);
	  
	  
	  model.addAttribute("books", bookRepository.findAll()); 
	  return "pages/listBook";
	  
	  }
	  
	  @GetMapping("edit/{id}") public String
	  showProviderFormToUpdate(@PathVariable("id") int id, Model model) { Book book
	  = bookRepository.findById(id) .orElseThrow(() -> new
	  IllegalArgumentException("Invalid book Id:" + id));
	  
	  model.addAttribute("book", book);
	  
	  return "pages/updateBook"; }
	  
	  
	  @PostMapping("update") public String updateProvider(@Valid Book book,
	  BindingResult result, Model model) {
	  
	  if (result.hasErrors()) { return "pages/updateBook"; }
	  
	  bookRepository.save(book); return "redirect:list";
	  
	  }
	 

}
