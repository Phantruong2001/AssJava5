package fpt.edu.controller.site;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import fpt.edu.domain.Customer;
import fpt.edu.model.CustomerDto;
import fpt.edu.service.CustomerService;

@Controller
@RequestMapping("site/commons")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping("add")
	public String add(Model model) {

		Customer customer = new Customer();

		model.addAttribute("customer", customer);

		return "site/commons/register";
	}

	@GetMapping("forgot")
	public String forgotPassword(Model model) {

		Customer customer = new Customer();

		model.addAttribute("customer", customer);

		return "site/commons/forgotpass";
	}

	@RequestMapping("")
	public String list(ModelMap model) {
		List<Customer> list = customerService.findAll();

		model.addAttribute("customers", list);

		return "admin/accounts/list";
	}

	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("customer") CustomerDto dto,
			BindingResult result) {

		if (result.hasErrors()) {
			return new ModelAndView("site/commons/register");
		}

		Customer customer = customerService.findByName(dto.getName());

		if (customer != null) {

			model.addAttribute("message", "Customer is empty !!!");

			return new ModelAndView("forward:/alogin");

		}

		Customer entity = new Customer();
		BeanUtils.copyProperties(dto, entity);
		entity.setRegisteredDate(new Date());
		entity.setStatus((short) 1);
		entity.setRole(false);

		customerService.save(entity);

		model.addAttribute("message", "Customer is saved !!!");

		return new ModelAndView("redirect:/alogin", model);
	}

}
