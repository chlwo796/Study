package org.zerock.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.web.vo.Product;

@Controller
public class SampleController3 {

	private static final Logger LOGGER = LoggerFactory.getLogger(SampleController3.class);
	
	@RequestMapping("/doD")
	public String doD( Model model ) {
		LOGGER.info("doD Call............");
		
		Product product = new Product( "Sample product", 10000);
		model.addAttribute(product);
		return "productDetail";
	}
}
