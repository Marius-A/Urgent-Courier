package com.mariusiliescu.spring.controller;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mariusiliescu.spring.model.entities.persoane.Client;
import com.mariusiliescu.spring.model.service.ClientService;

@Controller
public class LoginController {

	@Autowired
	private ClientService customerService;
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginForm() {
		return "login";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String showHomeForm() {
		return "home";
	}
	

	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String verifyLogin(@RequestParam String userId, 
    		@RequestParam String password, HttpSession session, Model model) {
        
		//customerService.adaugareFacturi();
		
		Client customer = customerService.loginClient(userId, password);
		if (customer == null) {
			model.addAttribute("loginError", "Error logging in. Please try again");
			return "login";
		}
		session.setAttribute("loggedInUser", customer);
		
	    AtomicInteger counter = (AtomicInteger) session.getAttribute("Count");
	    if (counter == null) {
	        counter = new AtomicInteger(60*15);
	        session.setAttribute("Count", counter);
	    }
		
        return "redirect:home";
    }

	@RequestMapping(value = "/{userId}")
	public String getUserProfile(@PathVariable String userId, Map<String, Object> model) {
		
		Client customer = customerService.findClient(userId);
		model.put("user", customer);
		return "/view";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("loggedInUser");
		return "redirect:login";
	}
}
