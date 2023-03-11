package fpt.edu.controller.admin;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import fpt.edu.domain.Product;
import fpt.edu.model.ProductDto;
import fpt.edu.repository.ProductRepository;
import fpt.edu.service.ProductService;




@Controller
@RequestMapping("admin/commons")
public class HomeAdminController {
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductService productService;
	
	@ModelAttribute("products")
	public List<ProductDto> getProducts(){
		return productService.findAll().stream().map(item->{
			ProductDto dto = new ProductDto();
			BeanUtils.copyProperties(item, dto);
			
			return dto;
		}).toList();
	}
	
	@GetMapping("home")
	public String index(Model model) {
		
		
		return "admin/commons/home";
	}
}
