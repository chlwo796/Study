package org.zerock.web.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {

	private static final Logger logger = LoggerFactory.getLogger(SampleController.class); 
	
	@RequestMapping("doA")
	public String doA() {
		logger.info("doA Call.............");
		return "result";
	}
	@RequestMapping(value="doB")
	public String doB() {
		logger.info("doB Call.............");
		return "result";
	}
}
