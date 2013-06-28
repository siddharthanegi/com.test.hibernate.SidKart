package com.test.hibernate.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;
import com.test.hibernate.form.Category;
import com.test.hibernate.form.Customer;
import com.test.hibernate.form.OrderInfo;
import com.test.hibernate.form.Product;
import com.test.hibernate.service.CategoryService;
import com.test.hibernate.service.CustomerService;
import com.test.hibernate.service.OrderService;
import com.test.hibernate.service.ProductService;
import com.test.hibernate.xmlForm.Orders;
import com.test.hibernate.xmlForm.Products;
import com.test.hibernate.xmlService.MarshallerService;
import com.test.hibernate.xmlService.TransformationService;

@Controller
@SessionAttributes({ "custID", "custName", "SessionCustomer","SelectedProducts" })
public class CustomerController {
	
	private static final Logger LOGGER_INFO= Logger.getLogger(CustomerController.class);
	private static final String SESSION_CUSTOMER="SessionCustomer";

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private MarshallerService marshallerService;
	
	@Autowired
	private TransformationService transformationService;
	

	@RequestMapping(value = "customerRegistration", method = RequestMethod.POST)
	public String registrationHandler(
			@ModelAttribute("customer") Customer customer, BindingResult rs,
			Model map) {

		// Adding new Customer record into the Customer table
		Integer custID = customerService.createRecord(customer);
		map.addAttribute("custID", custID);
		map.addAttribute("custName", customer.getFirstName());
		customer.setId(custID);
		map.addAttribute(SESSION_CUSTOMER, customer);
		return "welcome";
	}

	@RequestMapping(value = "checkCredentials", method = RequestMethod.POST)
	public String loginHandler(@RequestParam("custId") Integer id, Model map) {

		// Check in Database
		Customer customer = customerService.getCustomerById(id);

		if (customer != null) {
			map.addAttribute("custID", id);
			map.addAttribute("custName", customer.getFirstName());
			map.addAttribute(SESSION_CUSTOMER, customer);
			return "welcome";
		} else {
			return "login";
		}
	}

	@RequestMapping(value = "customer/productDisplay")
	public String getProducts(Map<String, Object> map) {

		map.put("productList", productService.listRecords());
		map.put("product", new Product());

		return "CustomerProductSelection";

	}

	@RequestMapping(value = "*/{custID}/selection")
	public String selectionDetail(
			@RequestParam("selection") List<Integer> selection,
			Map<String, Object> map) {

		List<Product> selectedProducts = new ArrayList<Product>();
		Iterator<Integer> it = selection.iterator();
		while (it.hasNext()) {

			Integer id = it.next();
			selectedProducts.add(productService.getProductById(id));
			LOGGER_INFO.info("id:"+id);  
			
		}
		map.put("SelectedProducts", selectedProducts);
		return "selectionDetails";

	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "*/{custID}/placeOrder", method = RequestMethod.POST)
	public String placeOrder(Model model, HttpSession session,
			@RequestParam("orderQty") List<Integer> orderQty) {

		List<Product> p = (List<Product>) session
				.getAttribute("SelectedProducts");
		OrderInfo order = new OrderInfo();
		order.setCustomer((Customer) session.getAttribute(SESSION_CUSTOMER));
		Iterator<Product> it = p.iterator();
		Iterator<Integer> qIt = orderQty.iterator();
		Set<Product> proSet = new HashSet<Product>();

		while (it.hasNext()) {

			Product id = it.next();
			if ((id.getQuantity() - qIt.next()) < 0) {
				model.addAttribute("error", 1);
				return "selectionDetails";
			}
		}
		it = p.iterator();
		qIt = orderQty.iterator();

		while (it.hasNext()) {

			Product id = it.next();

			// Updating Database
			Integer qty = id.getQuantity() - qIt.next();

			LOGGER_INFO.info("Info.."+qty);

			productService.alterQuantity(id.getId(), qty);

			proSet.add(id);
			LOGGER_INFO.info("Name:"+id.getName());
		}
		order.setProduct(proSet);

		Date date = new Date();
		order.setOrderDate(date);
		Integer oid = orderService.createOrder(order);
		session.setAttribute("OrderID", oid);
		return "success";

	}

	@RequestMapping(value = "getOrders")
	public String displayAllOrders(Map<String, Object> map) {

		List<OrderInfo> allOrders = orderService.getAllOrders();
		map.put("allOrders", allOrders);

		return "allOrders";

	}

	@RequestMapping(value = "/getCustomerOrder")
	@ResponseBody
	public String getCustomerOrder(HttpSession session) {

		
		Customer customer = (Customer) session.getAttribute(SESSION_CUSTOMER);
		Set<OrderInfo> orders = orderService.getOrderByCustId(customer);
		Gson gson = new Gson();
		LOGGER_INFO.info("Orders Json.."+gson.toJson(orders));
		return gson.toJson(orders);

	}

	@RequestMapping(value = "{usermode}/findCustomerHandler")
	@ResponseBody
	public String findCustomer(@RequestParam("choice") int choice,
			@RequestParam("searchParam") String searchParam) {
		Gson gson = new Gson();
		switch (choice) {

		case 1:
			Integer id = Integer.parseInt(searchParam);
			return gson.toJson(customerService.getCustomerById(id));
		case 2:

			return gson.toJson(customerService
					.getCustomerByLastName(searchParam));
		default:
			return gson.toJson(customerService.getCustomerByCity(searchParam));

		}

	}

	@RequestMapping(value = "{usermode}/getCustomerOrder")
	@ResponseBody
	public String findOrderbyCustomer(@RequestParam("inputField") Integer id) {

		Customer customer = customerService.getCustomerById(id);
		Gson gson = new Gson();

		return gson.toJson(orderService.getOrderByCustId(customer));
	}

	@RequestMapping(value = "customer/Browse")
	public String browse(Model map) {

		List<Category> categories = categoryService.getAllCategories();
		map.addAttribute("category", new Category());
		map.addAttribute("categories", categories);
		return "ProductBrowse";

	}

	@RequestMapping(value = "customer/BrowseProduct")
	@ResponseBody
	public String browseProducts(@RequestParam("category") String category,
			@RequestParam("price") int price) {

		Category c = new Category();
		List<Product> products = new ArrayList<Product>();
		int startPrice = 0, maxPrice = price;
		if (category.equals("all") && price == 0) {
			products = productService.listRecords();
		} else {
			maxPrice = price;
			if (price == 0) {
				startPrice = 0;
				maxPrice = 50000;
			} else if (price == 500) {
				maxPrice = price;
			} else if (price == 1000) {
				startPrice = 500;
			} else if (price == 2000) {
				startPrice = 1000;
			} else if (price == 3000) {
				startPrice = 2000;
			} else if (price == 5000) {
				startPrice = 3000;
			} else {
				startPrice = 5000;
			}
			c = categoryService.getCategoryByName(category);
			products = productService.getProductByCategoryAndPrice(c,
					startPrice, maxPrice);
		}

	
		Gson gson = new Gson();
		return gson.toJson(products);
	}

	@RequestMapping(value = "admin/Today")
	@ResponseBody
	public String todayOrders() throws ParseException {

		Calendar currentDate = Calendar.getInstance();
		String mChek = "", dChek = "";
		mChek = dashFormat(currentDate.get(Calendar.MONTH) + 1);
		dChek = dashFormat(currentDate.get(Calendar.DAY_OF_MONTH));

		String dateStr = currentDate.get(Calendar.YEAR) + mChek
				+ (currentDate.get(Calendar.MONTH) + 1) + dChek
				+ currentDate.get(Calendar.DAY_OF_MONTH);
		Date fromDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);

		int d = currentDate.get(Calendar.DAY_OF_MONTH);
		int m = currentDate.get(Calendar.MONTH) + 1;
		int y = currentDate.get(Calendar.YEAR);

		// Date Checks
		List<int[]> bMonths=Arrays.asList(new int[]{1,3,5,7,8,10});
		
		if (bMonths.contains(m)) {
			if (d == 31) {
				d = 1;
				if (m == 12) {
					m = (m + 1) % 12;
					y++;
				} else {
					m++;
				}
			} else {
				d++;
			}
		} else {
			if (m == 2 && d == 28) {
				d = 1;
				m++;
			} else if (d == 30) {
				d = 1;
				m = (m + 1) % 12;
			} else {
				d++;
			}

		}
		// Date Check End

		dChek = dashFormat(d);
		mChek = dashFormat(m);
		dateStr = y + mChek + m + dChek + d;
		
		Date toDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		Gson gson = new Gson();
		LOGGER_INFO.info("Info.."+gson.toJson(orderService.getOrderBetweenDates(
				fromDate, toDate)));
		return gson.toJson(orderService.getOrderBetweenDates(fromDate, toDate));
	}

	public String dashFormat(int m) {
		String mChek;
		if (m < 10) {
			mChek = "-0";
		} else {
			mChek = "-";
		}
		return mChek;
	}
	@RequestMapping(value="admin/GetOrderXml")
	@ResponseBody
	public byte[] createXmlReport(HttpSession session,HttpServletResponse response)  throws IOException, TransformerException{
		
		@SuppressWarnings("unchecked")
		List<OrderInfo> orderList= (List<OrderInfo>) session.getAttribute("object_Xml");
		System.out.println(orderList.isEmpty());
		Orders xmlOrders=new Orders();
		xmlOrders.setOrder(orderList);
		String result=marshallerService.doMarshalling(xmlOrders);
		FileWriter fw=new FileWriter("/Workspace/testSpringHibernate/OrderXml.xml");
		fw.write(result);
		fw.close();
		
		File xmlFile= new File("/Workspace/testSpringHibernate/OrderXml.xml");
		byte bytes[]=FileCopyUtils.copyToByteArray(xmlFile);
	    response.setHeader("Content-Disposition", "attachment; filename=\"" + xmlFile.getName() + "\"");
		response.setContentLength(bytes.length);
		response.setContentType("application/xml");
		return bytes;
	}

}
