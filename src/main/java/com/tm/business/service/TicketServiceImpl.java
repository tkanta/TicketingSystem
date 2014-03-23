package com.tm.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tm.data.dao.TicketDao;
import com.tm.data.domain.User;

@Service("ticketService")
@Repository
@Transactional
public class TicketServiceImpl implements TicketService{
	
	@Autowired
	private TicketDao ticketDao;
	
	@Transactional(readOnly = true)
	public List<User> findAllAsignee(){
		return ticketDao.findAllAsignee();
	}
}
