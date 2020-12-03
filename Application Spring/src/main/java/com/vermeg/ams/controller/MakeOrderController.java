package com.vermeg.ams.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vermeg.ams.entities.Book;
import com.vermeg.ams.repositories.BookRepository;

@Controller
@RequestMapping(value = "pages")
public class MakeOrderController {
	 @GetMapping(value = "makeOrder")
	    public String mmDashboard(Model model) {
	    	return "redirect:listi";
	    }
	   
		private final BookRepository bookRepository;
		@Autowired // IOC
		public MakeOrderController(BookRepository bookRepository) {
			this.bookRepository = bookRepository;
		}
		
		@GetMapping("listi") // @ResponseBody 
		  public String listProviders(Model model)
		  {
		  
		  List<Book> lp = (List<Book>) bookRepository.findAll();
		  
		  if (lp.size() == 0) { lp = null; } model.addAttribute("books", lp);
		  
		  return "pages/makeOrder"; 
		  // System.out.println(lp);
		  
		  // return "Nombre de fournisseur = " + lp.size(); }
		  }
}
