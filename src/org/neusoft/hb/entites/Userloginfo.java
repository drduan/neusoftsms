package org.neusoft.hb.entites;

import java.util.Date;

/**
 * Userloginfo entity. @author MyEclipse Persistence Tools
 */

public class Userloginfo implements java.io.Serializable {

	// Fields

	private Integer logid;
	private Userinfo userinfo;
	private Date logdate;
	private Integer logtype;

	// Constructors

	/** default constructor */
	public Userloginfo() {
	}

	/** minimal constructor */
	public Userloginfo(Userinfo userinfo, Date logdate) {
		this.userinfo = userinfo;
		this.logdate = logdate;
	}

	/** full constructor */
	public Userloginfo(Userinfo userinfo, Date logdate, Integer logtype) {
		this.userinfo = userinfo;
		this.logdate = logdate;
		this.logtype = logtype;
	}

	// Property accessors

	public Integer getLogid() {
		return this.logid;
	}

	public void setLogid(Integer logid) {
		this.logid = logid;
	}

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public Date getLogdate() {
		return this.logdate;
	}

	public void setLogdate(Date logdate) {
		this.logdate = logdate;
	}

	public Integer getLogtype() {
		return this.logtype;
	}

	public void setLogtype(Integer logtype) {
		this.logtype = logtype;
	}

}