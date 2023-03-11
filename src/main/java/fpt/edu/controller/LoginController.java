package fpt.edu.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import fpt.edu.domain.Account;
import fpt.edu.domain.Customer;
import fpt.edu.model.AccountDto;
import fpt.edu.model.AdminLoginDto;
import fpt.edu.model.CustomerDto;
import fpt.edu.service.AccountService;
import fpt.edu.service.CustomerService;

@Controller
public class LoginController {
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private HttpSession httpSession;
	
	@GetMapping("alogin")
	public String login(ModelMap model) {
		model.addAttribute("account", new CustomerDto());
		return "/admin/accounts/login";
	}
	
	
	@PostMapping("alogin")
	public ModelAndView login(ModelMap model, @Valid @ModelAttribute("account") CustomerDto dto,
			BindingResult result) {
		if(result.hasErrors()) {
			return new ModelAndView("/admin/accounts/login", model);
		}
		
		Customer customer = customerService.login(dto.getName(), dto.getPassword());
				
		
		if(customer == null) {
			model.addAttribute("message", "Invalid username or password!");
			return new ModelAndView("/admin/accounts/login", model);
		}
		
		httpSession.setAttribute("username", customer.getName());
		
		Object ruri = httpSession.getAttribute("redirect-uri");
		
		if(ruri != null) {
			httpSession.removeAttribute("redirect-uri");
			return new ModelAndView("redirect:" + ruri);
		}
		
		if (customer.isRole() == true) {
			
			return new ModelAndView("redirect:/admin/commons/home", model); // trả về home
		} 
		
		return new ModelAndView("redirect:/site/commons/home", model); // trả về home user
	}
}
