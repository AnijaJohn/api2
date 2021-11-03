package com.Api2.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_user")
public class Users {
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column(name="id")
	private  Long id;
	@Column(name="name")
	private String name;
	@Column (name="dob")
	private Date dob;
	@Column (name="email",length=200)
	private String email;
	@Column(name="mobno")
	private String mobno;
	
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(Long id, String name, Date dob, String email, String mobno) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.email = email;
		this.mobno = mobno;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobno() {
		return mobno;
	}
	public void setMobno(String mobno) {
		this.mobno = mobno;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", dob=" + dob + ", email=" + email + ", mobno=" + mobno + "]";
	}
}