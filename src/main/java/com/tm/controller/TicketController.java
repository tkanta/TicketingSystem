package com.tm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.business.service.TicketService;
import com.tm.data.domain.User;

@Controller
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	@RequestMapping(value="/assignee", method = RequestMethod.GET)
	public String getAllAssignee(Model uiModel){
		
		List<User> assignee = ticketService.findAllAsignee();
		uiModel.addAttribute("assignee", assignee);
		return "assignee";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(Model uiModel){
		System.out.println("-------------------------Enter login");
		//List<User> assignee = ticketService.findAllAsignee();
		//uiModel.addAttribute("assignee", assignee);
		return "login";
	}
}
