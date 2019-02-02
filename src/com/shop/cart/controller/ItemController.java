package com.shop.cart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.shop.cart.DAO.ItemDAO;
import com.shop.cart.model.Item;
import com.shop.cart.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	List<Item> cartItems = new ArrayList<>();
	
	
	@GetMapping("/list")
	public String listItems(Model theModel){
		List<Item> theItems = itemService.getItems();
		theModel.addAttribute("items", theItems);
		return "list-items";
	}
	
	@GetMapping("/cart")
	public String goToCart(HttpServletRequest request, Model theModel){
		HttpSession session = request.getSession();
		List<Item> theItems = (List<Item>) session.getAttribute("theCart");
		theModel.addAttribute("items", theItems);
		return "list-cart";
	}
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){
		Item theItem = new Item();
		theModel.addAttribute("item", theItem);
		return "item-form";
	}
	
	@PostMapping("/saveItem")
	public String saveItem(@ModelAttribute("item") Item theItem){
		itemService.saveItem(theItem);
		return "redirect:/item/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("itemId") int theId,
			Model theModel){
		Item theItem = itemService.getItems(theId);
		theModel.addAttribute("item", theItem);
		return "item-form";
	}
	
	@GetMapping("/delete")
	public String deleteItem(@RequestParam("itemId") int theId){
		itemService.deleteItem(theId);
		return "redirect:/item/list";
	}
	
	@RequestMapping("/processAddToCart")
	public String addToCartOrCheckOut(HttpServletRequest request, Model theModel){
		String action = request.getParameter("action");
		if(action.equals("Add To Cart")){
			String [] chkBox = request.getParameterValues("ckbx");
			for(int i=0; i<chkBox.length; i++){
				int theId = Integer.parseInt(chkBox[i]);
				Item theItem = itemService.getItems(theId);
				int qty = Integer.parseInt(request.getParameter("qty"+chkBox[i]));
				theItem.setQuantity(qty);
				theItem.setTotal(qty);
				cartItems.add(theItem);
				HttpSession session = request.getSession();
				session.setAttribute("theCart", cartItems);
			}
		} else{
			return "redirect:/item/cart";
		}
		return "redirect:/item/list";
	}
	
	@GetMapping("/thank-you")
	public String checkOutThankU(){
		return "thank-you";
	}
	
	@RequestMapping("/logout")
	public String  logOut(SessionStatus status){
		status.setComplete();
		return "redirect:/";
	}
	
	@RequestMapping("/help")
	public String goToHelp(){
		return "help";
	}
	
}
