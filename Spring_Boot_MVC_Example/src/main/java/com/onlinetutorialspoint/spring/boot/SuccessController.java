package com.onlinetutorialspoint.spring.boot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onlinetutorialspoint.bean.SuccessBean;

@Controller
//@RequestMapping(value="/employee")
public class SuccessController {
	
	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public String init(Model model) {
		model.addAttribute("msg", "Please Enter Your Login Details");
		return "success.jsp";
	}
	
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public String submit(Model model,
			@ModelAttribute("successBean") SuccessBean successBean) {
		if (successBean != null) {
			
				model.addAttribute("msg", successBean.getName());
				return "referenceid.jsp";
		
		} else {
			model.addAttribute("error", "Please enter Details");
			return "success.jsp";
		}
	}
	
}
