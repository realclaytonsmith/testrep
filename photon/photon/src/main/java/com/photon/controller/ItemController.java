package com.photon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.photon.model.Item;
import com.photon.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listItem", itemService.getAllItems());
		return "home";
	} 
	
	@GetMapping("/newItem")
	public String newItemPage(Model model) {
		Item item = new Item();
		model.addAttribute("item", item);
		return "newitem";
	}
	
	@PostMapping("/saveItem")
	public String saveItem(@ModelAttribute("item") Item item) {
		itemService.saveItem(item);
		return "redirect:/";
	}
	
	@GetMapping("/updateItem/{id}")
	public String updatePage(@PathVariable(value = "id") long id, Model model) {
		Item item = itemService.getItemById(id);
		model.addAttribute("item", item);
		return "updateitem";
	}
	
	@GetMapping("/deleteItem/{id")
	public String deleteItem(@PathVariable(value = "id") long id) {
		this.itemService.deleteItemById(id);
		return "redirect:/";
	}
}
