package com.tm.data.dao;

import java.util.List;

import com.tm.data.domain.Ticket;
import com.tm.data.domain.User;

public interface TicketDao {
	
	public List<Ticket> findTicketsById(Long id);
	public List<Ticket> findAllTickets();
	public List<User> findAllUsers();
	public Ticket saveOrUpdateTicket(Ticket ticket);
	public User findUserById(Long id);
	public User findUserWithTicket(Long id);
	public List<User> findAllAsignee();
}
