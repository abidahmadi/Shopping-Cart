package com.shop.cart.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.shop.cart.model.*;
import com.shop.cart.userservice.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@InitBinder
	public void initBinder(WebDataBinder databinder){
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		databinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@RequestMapping("/")
	public String showLogin(Model theModel){
		User theUser = new User();
		theModel.addAttribute("user",theUser);
		return "login";
	}
	
	
	/*@RequestMapping("/validateLogin")
	public String validateLogin(@Valid @ModelAttribute("user") User theUser,
			BindingResult theBindingResult) {
		if(theBindingResult.hasErrors()){
			return "login";
		}else if(userService.isUserValid(theUser)){
			System.out.println("Im valid "+userService.isUserValid(theUser));
				return "redirect:/item/list";
		}else{
			
			return "login";
		}
			
		}*/
	
	@RequestMapping("/validateLogin")
	public String validateLogin(@Valid @ModelAttribute("user") User theUser,
			BindingResult theBindingResult, Model theModel) {
		if(theBindingResult.hasErrors()){
			return "login";
		}else if(userService.isUserValid(theUser)){
			System.out.println("Im valid "+userService.isUserValid(theUser));
				return "redirect:/item/list";
		}else{
			theModel.addAttribute("msg", "Invalid username and password");
			return "login";
		}
			
		}
	
	
	
	
	}
	

