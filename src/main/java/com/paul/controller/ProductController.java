/**
 * 
 */
package com.paul.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.paul.service.ProductService;
import com.paul.spring.beans.Product;
import com.paul.spring.beans.ProductForm;

/**
 * @author hzzhouminmin
 *
 */
@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/input")
	public String inputProduct() {
		return "productForm";
	}

	@RequestMapping("/productSave")
	public String saveProduct(ProductForm productForm, RedirectAttributes redirectAttributes) {

		if(productForm == null) {
			return "redirect:/input";
		}

		Product product = new Product();
		product.setName(productForm.getName());
		String nubmerStr = productForm.getNumber();
		Long numberLong = null;
		try {
			numberLong = Long.parseLong(nubmerStr); 
		} catch (Exception e) {
			System.out.println("number parse error");
		}
		product.setNumber(numberLong);
		product.setCategory(productForm.getCategory());

		productService.add("product", product);
		
//		redirectAttributes.addAttribute("message", "This is a redirect attribute");
		redirectAttributes.addFlashAttribute("message", "This is a redirect attribute");

		return "redirect:/viewProduct";
	}
	
	@RequestMapping("/viewProduct")
	public String viewProduct(HttpServletRequest request,@ModelAttribute("message") String message, Model model) {
		model.addAttribute("product", productService.get("product"));
		System.err.println(message);
		return "/productDetails";
	}
	
	@ModelAttribute("wode")
	public String haveString(@RequestParam(value = "param", defaultValue = "default:") String param){
		return param+"+jia";
	}
	
	@RequestMapping("/testModel")
	public String testModelAttribute(
			@RequestParam(value = "param", defaultValue = "default:") String param, 
			@ModelAttribute(value = "wode") String wode){
		wode = wode + "+jia2";
		System.err.println(param + ", " + wode);
		return "page";
	}
}
