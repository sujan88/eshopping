package edu.mum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.domain.Category;
import edu.mum.service.CategoryService;

@Controller
@RequestMapping("/user")
public class CategoryUserController {
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/category")
	public String categoriesUser(Model model){
		List<Category> categories=categoryService.getCategoryList();
		model.addAttribute("categories",categories);
		return "user/categoryUser";
	}
	
	@RequestMapping("/getProduct")
	public String productFromCategory(Model model){
		List<Category> categories=categoryService.getCategoryList();
		model.addAttribute("categories",categories); 
		return "user/productList";
		
	}

}
