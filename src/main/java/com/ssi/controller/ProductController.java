package com.ssi.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssi.models.Product;
import com.ssi.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;

	//mapping for savechange
	@RequestMapping("/savechanges")
	public ModelAndView saveChanges(@ModelAttribute("product")Product product)
	{
		productService.saveProduct(product);
		ModelAndView mv=new ModelAndView("redirect:viewproducts");
		return mv;
	}
	
	// mapping to update a form
	@RequestMapping("update")
	public ModelAndView showUpdateForm(@RequestParam("pcode")int code) {
		ModelAndView mv = new ModelAndView("pupdate");
		Product product = productService.productDetails(code);
		mv.addObject("product",product);
		
		List<String> names=Arrays.asList("Mouse","PC","Keyboard","HDD","SDD","USB Drive");
		mv.addObject("pnames",names);
		return mv;
	}

	// mapping for view all list
	@RequestMapping("/viewproducts")
	public ModelAndView showProductList() {
		// we will fetch product from db and add them to ModelAndView Object
		List<Product> products = productService.getAllProducts();
		ModelAndView mv = new ModelAndView("product-list");
		mv.addObject("products", products);
		return mv;
	}

	// mappig for dodelete
	@RequestMapping("/dodelete")
	public ModelAndView deleteProductDetails(@RequestParam("pcode") int code) {
		Product product = productService.deleteProduct(code);
		ModelAndView mv = new ModelAndView("delete-confirm");
		mv.addObject("product", product);
		return mv;

	}

	// mapping for delete input page
	@RequestMapping("/deleteproduct")
	public String deleteProduct() {
		return "deletepage";

	}

	// mapping for save product details
	@RequestMapping("/saveproduct")
	public ModelAndView saveProductDetails(@Valid @ModelAttribute("product") Product product,BindingResult result) {
		// save into databases
		 if(result.hasErrors())
		 {
			 //some errors are occurred
			// ModelAndView mv=new ModelAndView("errpage");
			 ModelAndView mv=new ModelAndView("pentry");
			 return mv;
			 
		 }
		
		Product pr = productService.saveProduct(product);
		// provide response
		ModelAndView mv = new ModelAndView("save-confirm");
		return mv;
	}

	// mapping for add product
	@RequestMapping("/newproduct")
	public String addProduct() {
		return "pentry";
	}

	// mapping to process search
	@RequestMapping("/dosearch")
	public ModelAndView searchProduct(@RequestParam("pcode") int code) {
		// talk to service to get product details
		Product product = productService.productDetails(code);

//			ModelAndView modelAndView=new ModelAndView("WEB-INF/pages/details.jsp");
		ModelAndView modelAndView = new ModelAndView("details");
		modelAndView.addObject("product", product);
		return modelAndView;
	}

	// mapping to show input page
	@RequestMapping("/searchinput")
	public String showSearchForm() {
		// return "WEB-INF/pages/searchpage.jsp";
		return "searchpage";
	}

}
