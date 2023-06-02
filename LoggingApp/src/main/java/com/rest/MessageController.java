package com.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	
	private Logger logger=LoggerFactory.getLogger(MessageController.class);
	
	@GetMapping("/welcome")
	public String welcomeMessage()
	{
		logger.info("Welcome message execution started...");
		String msg="Welcome to Mumbai";
		logger.info("Welcome message execution ended...");
		String value=null;
		System.out.println(value.length());
		return msg;
	}
	@GetMapping("/greet")
	public String greetMessage()
	{
		logger.info("Greet message execution started...");
		String msg="Greeting from Vsp Team";
		logger.info("Greet message execution ended...");
		String value=null;
		System.out.println(value.length());
		return msg;
	}
}
