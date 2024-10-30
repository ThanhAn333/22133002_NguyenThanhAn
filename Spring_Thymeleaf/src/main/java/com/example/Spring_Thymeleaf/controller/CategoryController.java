package com.example.Spring_Thymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org .springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Spring_Thymeleaf.entity.Category;
import com.example.Spring_Thymeleaf.service.CategoryService;

import vn.iostar.service.ICategoryService;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@RequestMapping("")
	public String all(Model model) {
		List<Category> list = categoryService.findAll();
		model.addAttribute("list", list);

		return "admin/category/list";
	}

    @GetMapping("/categories/new")
    public String createCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "category-form";
    }


}