package com.controller.SpringbootController.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.data.redis.usr.User;

@Controller
public class WebReturnHTMLController {
	@RequestMapping(value ="/findall2",method=RequestMethod.GET)
	public String getAllUserInformation(@RequestParam String USER_ID){
		String PKUSER_ID = "";
		PKUSER_ID = USER_ID;
		User user = new User();
        user.printAllUserInformation(user.getAllUserInformation(USER_ID));
        return "hello";
	}
}
