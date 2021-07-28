package com.tm.data.dao.daoimpl;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.tm.data.dao.TicketDao;
import com.tm.data.domain.Ticket;
import com.tm.data.domain.User;

public class TestTicketDaoImpl {
	
	
	public static void main(String[] args){
		findUserWithTicket();
	}
	
	public static void findUserWithTicket(){
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/application-data.xml");
        ctx.refresh();
        
        TicketDao ticketDao = ctx.getBean("ticketDao", TicketDao.class);
        User u = ticketDao.findUserWithTicket(3L);
        System.out.println(u.getEmail());
    	System.out.println(u.getTickets().iterator().next().getComments());
	}
	
	
	public static  void findUserById(){
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/application-data.xml");
        ctx.refresh();
        
        TicketDao ticketDao = ctx.getBean("ticketDao", TicketDao.class);
        User u = ticketDao.findUserById(3L);
        System.out.println(u.getEmail());
    	System.out.println(u.getTickets().iterator().next().getComments());
	}
	private static void findAssignee(){
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/application-data.xml");
        ctx.refresh();
        
        TicketDao ticketDao = ctx.getBean("ticketDao", TicketDao.class);
        List<User> asignee = ticketDao.findAllAsignee();
        for(User u: asignee){
        	System.out.println(u.getEmail());
        	System.out.println(u.getTickets().iterator().next().getComments());
        }
	}
	private static void saveTicket(){
		try{
		Ticket ticket = new Ticket();
		ticket.setSummary("summary");
		ticket.setDescription("description");
		ticket.setComments("comments");
		ticket.setStatus("A");
		ticket.setPriority("p1");
		ticket.setAssigned("A");
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/application-data.xml");
        ctx.refresh();
        
        TicketDao ticketDao = ctx.getBean("ticketDao", TicketDao.class);
		User user = ticketDao.findUserById(3L);	
		
		ticket.setUser(user);
		Ticket tkt = ticketDao.saveOrUpdateTicket(ticket);
		System.out.println("Ticket was saved with id : "+tkt.getId());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	
	
	private static void findAllUsers(){
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/application-data.xml");
        ctx.refresh();
        
        TicketDao ticketDao = ctx.getBean("ticketDao", TicketDao.class);
        List<User> users = ticketDao.findAllUsers();
        printUser(users);
	}
	
	
	private static void printUser(List<User> users){
		for(User u : users){
			System.out.println(u.getEmail());
		}
	}

	//Test1
	//Test2
}
