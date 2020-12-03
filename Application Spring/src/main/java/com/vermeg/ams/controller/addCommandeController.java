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
import org.springframework.web.bind.annotation.RequestParam;

import com.vermeg.ams.entities.Book;
import com.vermeg.ams.entities.Commande;
import com.vermeg.ams.repositories.BookRepository;
import com.vermeg.ams.repositories.CommandeRepository;;

@Controller
@RequestMapping(value = "pages")
public class addCommandeController {
	
	  @GetMapping(value = "listCommande") 
	 public String mmDashboard(Model model) {
	  return "redirect:./listt"; }
	 
	private final CommandeRepository commandeRepository;
	private final BookRepository bookRepository;

	@Autowired
	public addCommandeController(CommandeRepository commandeRepository, BookRepository bookRepository) {
		this.commandeRepository = commandeRepository;
		this.bookRepository = bookRepository;
	}
	
	@GetMapping("listt")
	public String listCommandes(Model model) {
		

		List<Commande> la = (List<Commande>) commandeRepository.findAll();
		List<Book> lp = (List<Book>) bookRepository.findAll();
		if ((la.size() == 0) || (lp.size()==0)) {
			la = null;
			lp=null;
		}
		model.addAttribute("commandes", la);
		model.addAttribute("books", lp);
		return "pages/listCommande";
	}

	
	
	@GetMapping("addd")
	public String showAddArticleForm(Model model) {

		model.addAttribute("books", bookRepository.findAll());
		model.addAttribute("Commande", new Commande());
		return "pages/addCommande";
	}

	@PostMapping("addd")
	// @ResponseBody
	public String addCommande(@Valid Commande commande, BindingResult result,
			@RequestParam(name = "bookId", required = true) int p) {

		commandeRepository.save(commande);
		return "redirect:listt";

		// return article.getLabel() + " " +article.getPrice() + " " + p.toString();
	}

	
	@GetMapping("deletee/{id}")
	public String deleteProvider(@PathVariable("id") int id, Model model) {
		Commande commande = commandeRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
		
		commandeRepository.delete(commande);
		return "redirect:../listt";
	}

	@GetMapping("editt/{id}")
	public String showArticleFormToUpdate(@PathVariable("id") int id, Model model) {
		Commande commande = commandeRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid provider Id:" + id));

		model.addAttribute("commande", commande);
		model.addAttribute("books", bookRepository.findAll());
	

		return "pages/updateCommande";
	}

	@PostMapping("editt")
	public String updateArticle(@Valid Commande commande, BindingResult result, Model model,
			@RequestParam(name = "providerId", required = false) int p) {
		if (result.hasErrors()) {
			
			return "pages/updateCommande";
		}

		commandeRepository.save(commande);
		return "redirect:list";
	}
}