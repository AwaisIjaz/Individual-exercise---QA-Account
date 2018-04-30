package com.qa;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qa.controller.HomeController;


public class AppTest {
    
	@Test
    public void testApp(){
		HomeController hc = new HomeController();
		String result = hc.home();
		assertEquals();
	}		 
}
