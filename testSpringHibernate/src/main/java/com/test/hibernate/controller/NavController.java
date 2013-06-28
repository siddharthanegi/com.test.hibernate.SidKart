package com.test.hibernate.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.hibernate.form.Address;
import com.test.hibernate.form.Category;
import com.test.hibernate.form.Customer;
import com.test.hibernate.form.OrderInfo;
import com.test.hibernate.form.Product;
import com.test.hibernate.service.AddressService;
import com.test.hibernate.service.CategoryService;
import com.test.hibernate.service.CustomerService;
import com.test.hibernate.service.OrderService;
import com.test.hibernate.service.ProductService;

@Controller
public class NavController {

	private static Long totalRecords;
	private static final double MAX_RECORDS_PER_PAGE=5.0;

	@Autowired
	private ProductService productService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private OrderService orderService;
	
	@Autowired 
	private CategoryService categoryService;
	
	@Autowired
	private AddressService addressService;
	
	public static Long getTotalRecords() {
		return totalRecords;
	}

	public static void setTotalRecords(Long totalRecords) {
		NavController.totalRecords = totalRecords;
	}
	
	@RequestMapping(value="{usermode}")
	public String mainHandler(@PathVariable ("usermode") String uMode){
		
		setTotalRecords(productService.getCount());
		if(uMode.equals("admin")){
			return "AdminWelcome";}
		else{
			return "login";}
	}
	
	@RequestMapping(value="admin/pro_choice")
	public String pChoiceHandler(@RequestParam ("pChoice")int choice, Map<String ,Object> map,HttpSession session){
		
		switch(choice){
		
		case 1:
			int pageNo = (int) Math.ceil(getTotalRecords()/MAX_RECORDS_PER_PAGE);
			map.put("pageNo",pageNo);
			map.put("max",getTotalRecords().intValue());
			map.put("product", new Product());
			List<Product> productList=productService.listRecords();
			map.put("productList",productList);
			session.setAttribute("object_Xml", productList);
			return "products";
		case 2:
			map.put("warehouses",addressService.getAllRecords());
			map.put("warehouse", new Address());
			
			return "addRecord";
		case 3:	
			return "temp";
		default:
			return "addLocation";
		
		}
		
		
	}

	@RequestMapping(value="admin/cust_choice")
	public String cChoiceHandler(@RequestParam ("cChoice")int choice, Map<String ,Object> map, HttpSession session){
		
		switch(choice){
		
		case 1:
			map.put("customerList",customerService.listRecords() );
			map.put("customer",new Customer() );
			return "CustomerDetails";
		case 2:
			
			return "CustomerOrder";
		case 3:
			List<OrderInfo> allOrders=orderService.getAllOrders();
			map.put("allOrders",allOrders);
			session.setAttribute("object_Xml",allOrders);
			return "allOrders";
		default:
			return "temp";
		
		
		
		}
		}
	
	@RequestMapping(value="experiment")
	public String experiment(Model map){
		
		List<Category> categories=categoryService.getAllCategories();
		map.addAttribute("category", new Category());
		map.addAttribute("categories", categories);
		return "dropdown";
	}
	


}
