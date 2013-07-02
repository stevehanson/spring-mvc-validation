package com.codetutr.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codetutr.form.Subscriber;

@Controller
public class FormController {
	

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String loadFormPage(Model m) {
		m.addAttribute("subscriber", new Subscriber());
		return "formPage";
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String submitForm(@Valid Subscriber subscriber, BindingResult result, Model m) {
		if(result.hasErrors()) {
			return "formPage";
		}
		
		m.addAttribute("message", "Successfully saved person: " + subscriber.toString());
		return "formPage";
	}
}
