package com.log.login.Controllers;

import java.util.List;
import java.lang.String;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.log.login.models.PageRepository;
import com.log.login.models.data.Page;

@Controller
@RequestMapping(name ="/admin/pages")
public class AdminPanelController {
	
	@Autowired
	private PageRepository pageRepo;
	
	
//	public AdminPanelController(PageRepository pageRepo) {
//		this.pageRepo=pageRepo;
//	}
	
	@GetMapping("admin/pages")
	public String home(Model model) {
		List<Page> pages=pageRepo.findAll();
		model.addAttribute("pages",pages);
		return "admin/pages/home";
		
	
	}
	@GetMapping("admin/pages/add")
	public String add(@ModelAttribute Page page) {
		return "admin/pages/add";
	}
	
	@PostMapping("admin/pages/add")
	public String add(@Valid Page page, BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model) {
		if(bindingResult.hasErrors()) {
			return "admin/pages/add";
		}
	redirectAttributes.addFlashAttribute("message","page added");
	redirectAttributes.addFlashAttribute("alertclass","alert-success");
	
	String slug =page.getSlug()==" " ? page.getTitle().toLowerCase().replace(" ","-"):page.getSlug().toLowerCase().replace(" ","-");
	Page slugExists=pageRepo.findByslug(slug);
	
	if(slugExists !=null) {
		
		redirectAttributes.addFlashAttribute("message","Choose Another");
		redirectAttributes.addFlashAttribute("alertclass","alert-danger");
	}
	else {
		
		page.setSlug(slug);
		page.setSorting(100);
		
		pageRepo.save(page);
		
	}
	
	
	
	return "redirect:/admin/pages/add";
		
	}
	
	@GetMapping("/admin/pages/edit/{id}")
	public String edit(@PathVariable("id") int id , Model model) {
		Page page=pageRepo.getOne(id);
		model.addAttribute("page",page);
		return "admin/pages/edit";
	}
}
