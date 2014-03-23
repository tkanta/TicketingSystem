package com.tm.data.dao.daoimpl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tm.data.dao.TicketDao;
import com.tm.data.domain.Ticket;
import com.tm.data.domain.User;
import com.tm.util.Constants;

@Repository("ticketDao")
@Transactional
public class TicketDaoImpl implements TicketDao{
	
	private Log log = LogFactory.getLog(TicketDaoImpl.class);
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Ticket> findAllTickets(){
		return sessionFactory.getCurrentSession().createQuery("from Ticket t").list();
	}
	
	public List<Ticket> findTicketsById(Long id){
		return sessionFactory.getCurrentSession().getNamedQuery("ticket.findById").setParameter("id", id).list();
	}
	
	@Transactional(readOnly = true)
	public List<User> findAllUsers(){
		return sessionFactory.getCurrentSession().createQuery("from User u").list();
	}
	
	@Transactional(readOnly = true)
	public User findUserById(Long id){
		return (User)sessionFactory.getCurrentSession().getNamedQuery("user.findById").setParameter("id", id).uniqueResult();
	}
	
	
	public Ticket saveOrUpdateTicket(Ticket ticket){
		sessionFactory.getCurrentSession().saveOrUpdate(ticket);
		return ticket;
	}
	
	public List<User> findAllAsignee(){
		return sessionFactory.getCurrentSession().getNamedQuery("user.findAllAsignee").setParameter("groupId",Constants.ASSIGNEE_ID).list();
	}
	
	public User findUserWithTicket(Long id){
		return (User)sessionFactory.getCurrentSession().getNamedQuery("user.findUserWithTicket").setParameter("groupId",id).uniqueResult();
	}
	
}
