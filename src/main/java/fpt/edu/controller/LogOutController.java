package fpt.edu.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogOutController {
	@Autowired
	 HttpSession httpSession;
	
	@GetMapping("logout")
	public String index() {
		httpSession.removeAttribute("username");
		
		return "redirect:/site/commons/home";
	}
}
