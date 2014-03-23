package com.tm.data.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "tm_user")
@NamedQueries({
	@NamedQuery(name = "user.findById",query="select u from User u where u.id = :id"),
	@NamedQuery(name = "user.findAllAsignee",query="select u from User u where u.userGroupId = :groupId"),
	@NamedQuery(name = "user.findUserWithTicket",query="select distinct u from User u left join fetch u.tickets t where u.userGroupId = :groupId")
})
public class User extends BaseDomain{
	
	private static final long serialVersionUID = 2231231231233L;
	private Long id;
	private String email;
	private String fullName;
	private String password;
	private Long userGroupId;
	private int version;
	private Set<Ticket> tickets = new HashSet<Ticket>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "user_id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column (name = "user_email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column (name = "user_fullName")
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	@Column (name = "user_password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Version
	@Column(name = "version")
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	@OneToMany(mappedBy = "user",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval=true)
	public Set<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}
	public void addTicket(Ticket ticket){
		ticket.setUser(this);
		getTickets().add(ticket);
	}
	public void removeTicket(Ticket ticket){
		getTickets().remove(ticket);
	}
	
	
	@Column(name="user_group_id")
	public Long getUserGroupId() {
		return userGroupId;
	}
	public void setUserGroupId(Long userGroupId) {
		this.userGroupId = userGroupId;
	}
	
	
}
