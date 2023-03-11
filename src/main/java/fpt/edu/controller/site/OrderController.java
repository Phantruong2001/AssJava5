package fpt.edu.controller.site;


import java.util.Optional;



import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fpt.edu.domain.Order;
import fpt.edu.domain.OrderDetail;
import fpt.edu.domain.Product;
import fpt.edu.service.CartItemService;
import fpt.edu.service.OrderDetailService;
import fpt.edu.service.OrderService;
import fpt.edu.service.ProductService;


@Controller
@RequestMapping("site")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	OrderDetailService detailService;
	
	@Autowired
	CartItemService cartService;
	
	@PostMapping("orderDetail")
	public ModelAndView orderDetail(ModelMap model, @RequestParam("orderId") Integer orderId, @RequestParam("productId") Long productId) {
		
		Optional<Order> optOrder = orderService.findById(orderId);
		Order order = optOrder.get();
		double amount = order.getAmount();

		Optional<Product> optProduct = productService.findById(productId);
		Product product = optProduct.get();
		
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setOrder(order);
		orderDetail.setProduct(product);
		orderDetail.setUnitPrice(product.getUnitPrice());
		orderDetail.setQuantity( (int) (amount/orderDetail.getUnitPrice()));
		
		detailService.save(orderDetail);
		cartService.remove(productId);
		
		return new ModelAndView("redirect:/site/commons/home", model);
		
		
	}
}
