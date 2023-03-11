package fpt.edu.controller.site;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fpt.edu.domain.Account;
import fpt.edu.domain.CartItem;
import fpt.edu.domain.Product;
import fpt.edu.model.AccountDto;
import fpt.edu.model.CategoryDto;
import fpt.edu.model.ProductDto;
import fpt.edu.service.CartItemService;
import fpt.edu.service.CategoryService;
import fpt.edu.service.ProductService;

@Controller
@RequestMapping("site")
public class BuyProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	CartItemService cartService;
	
	@ModelAttribute("categories")
	public List<CategoryDto> getCategories(){
		return categoryService.findAll().stream().map(item->{
			CategoryDto dto = new CategoryDto();
			BeanUtils.copyProperties(item, dto);
			return dto;
		}).toList();
	}
	
	@GetMapping("productDetail/{productId}")
	public String view(@PathVariable ("productId") Long productId,Model model) {
		
		
		Optional<Product> opt = productService.findById(productId);
		ProductDto productDto = new ProductDto();
		
		Product entity = opt.get();
		BeanUtils.copyProperties(entity, productDto);
		productDto.setCategoryId(entity.getCategory().getCategoryId());
		
		System.out.println(productDto);
		
		model.addAttribute("product", productDto);
		
		return "site/buy-product";
	}
	
	@GetMapping("views")
	public String view(Model model) {
		model.addAttribute("carts", cartService.getAllItems());
		model.addAttribute("total", cartService.getAmount());
		
		return "site/cart";
	}
	
	@GetMapping("add/{productId}")
	public String add(ModelMap model, @PathVariable("productId") Long productId) {
		
		Optional<Product> product = productService.findById(productId);
		
		if(product != null) {
			CartItem item = new CartItem();
			item.setProductId(product.get().getProductId());
			item.setName(product.get().getName());
			item.setUnitPrice(product.get().getUnitPrice());
			item.setQuantity(1);
			
			cartService.add(item);
			model.addAttribute("carts", item);
			
			System.out.println(item);
		}
		return "redirect:/site/views";
	}
	
	@GetMapping("clear")
	public String clearCart() {
		cartService.clear();
		return "redirect:/site/views";
				
	}
	
	@GetMapping("delete/{productId}")
	public String removeCart(@PathVariable("productId") Long productId) {
		cartService.remove(productId);
		
		return "redirect:/site/views";	
				
	}
	
	
}
