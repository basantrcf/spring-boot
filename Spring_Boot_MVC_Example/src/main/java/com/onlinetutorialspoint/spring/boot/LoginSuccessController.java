package com.onlinetutorialspoint.spring.boot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onlinetutorialspoint.bean.LoginBean;
import com.onlinetutorialspoint.bean.SuccessBean;

@Controller
public class LoginSuccessController {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String init(Model model) {
		model.addAttribute("msg", "Please Enter Your Login Details");
		return "login.jsp";
	}
	
	@RequestMapping(value="/loginmethod",method = RequestMethod.POST)
	public String submit(Model model,
			@ModelAttribute("loginBean") LoginBean loginBean) {
		if (loginBean != null && loginBean.getUserName() != null
				& loginBean.getPassword() != null) {
			if (loginBean.getUserName().equals("test")
					&& loginBean.getPassword().equals("test123")) {
				model.addAttribute("msg", loginBean.getUserName());
				return "redirect:/success";
			} else {
				model.addAttribute("error", "Invalid Details");
				return "login.jsp";
			}
		} else {
			model.addAttribute("error", "Please enter Details");
			return "login.jsp";
		}
	}
	
	/*@RequestMapping(method = RequestMethod.POST)
	public String submit(Model model) {
		
			System.out.println("test");
			System.out.println("test");
			System.out.println("test");
				//model.addAttribute("msg", loginBean.getUserName());
				return "redirect:/success";
			
	}*/
	
	/*@RequestMapping(value = "success", method = RequestMethod.GET)
	public String initSuccess(Model model) {
		model.addAttribute("msg", "Please Enter Your Details");
		return "success.jsp";
	}*/
	
	/*@RequestMapping(value="/success",method = RequestMethod.POST, params="success")
	public String success() {
		if (successBean != null) {
			
				model.addAttribute("msg", successBean.getName());
				return "referenceid.jsp";
		
		} else {
			model.addAttribute("error", "Please enter Details");
			return "success.jsp";
		}
		return "test";
	}*/
}
