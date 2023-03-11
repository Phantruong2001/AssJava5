package fpt.edu.controller.site;

import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpSession;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fpt.edu.domain.CartItem;
import fpt.edu.domain.Customer;
import fpt.edu.domain.Order;
import fpt.edu.model.CustomerDto;
import fpt.edu.model.OrderDto;
import fpt.edu.service.CartItemService;
import fpt.edu.service.CustomerService;
import fpt.edu.service.OrderService;

@Controller
@RequestMapping("site")
public class BuyController {
	
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	HttpSession httpSession;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	CartItemService cartService;
	
	@GetMapping("payment/{productId}")
	public String buy(ModelMap model, @ModelAttribute("order") OrderDto dto, @PathVariable("productId") Long id) {
		
		Order order = new Order();
		BeanUtils.copyProperties(dto, order);
		
		String name = (String) httpSession.getAttribute("username");
		
		if(name == null) {
			return "redirect:/admin/login";
		}
		
		Customer customer = customerService.findByName(name);
		
		CartItem cartItem = cartService.findCartById(id);
		double amount = cartService.getAmount();	
		
		order.setOrderDate(new Date());
		order.setStatus((short) 1);
		order.setAmount(amount);
		order.setCustomer(customer);
		
		orderService.save(order);
		
		
		Integer orderId = order.getOrderId();
		model.addAttribute("orderId", orderId);
		
		Long productId = cartItem.getProductId();
		model.addAttribute("productId", productId);
		
		return "site/orderDetail";
	}
}
