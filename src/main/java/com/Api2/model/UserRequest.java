package com.Api2.model;

import java.util.Date;

public class UserRequest {
	
	public UserRequest(Long rid, String rname, Date rdob, String remail, String rmobno) {
		super();
		this.rid = rid;
		this.rname = rname;
		this.rdob = rdob;
		this.remail = remail;
		this.rmobno = rmobno;
	}
	private  Long rid;
	private String rname;
	private Date rdob;
	private String remail;
	private String rmobno;
	
	
	
	public UserRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public Date getRdob() {
		return rdob;
	}

	public void setRdob(Date rdob) {
		this.rdob = rdob;
	}

	public String getRemail() {
		return remail;
	}

	public void setRemail(String remail) {
		this.remail = remail;
	}

	public String getRmobno() {
		return rmobno;
	}

	public void setRmobno(String rmobno) {
		this.rmobno = rmobno;
	}

	
	@Override
	public String toString() {
		return "UserRequest{rid="+rid+",rname="+rname+",rdob="+rdob+",rmail="+remail+",rmobno="+rmobno+"}";
	}
	
	
	

}
