package org.neusoft.hb.entites;

import java.util.HashSet;
import java.util.Set;

/**
 * Userinfo entity. @author MyEclipse Persistence Tools
 */

public class Userinfo implements java.io.Serializable {

	// Fields

	private Integer uid;
	private String logname;
	private String keyword;
	private Set userloginfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Userinfo() {
	}

	/** minimal constructor */
	public Userinfo(String logname, String keyword) {
		this.logname = logname;
		this.keyword = keyword;
	}

	/** full constructor */
	public Userinfo(String logname, String keyword, Set userloginfos) {
		this.logname = logname;
		this.keyword = keyword;
		this.userloginfos = userloginfos;
	}

	// Property accessors

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getLogname() {
		return this.logname;
	}

	public void setLogname(String logname) {
		this.logname = logname;
	}

	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Set getUserloginfos() {
		return this.userloginfos;
	}

	public void setUserloginfos(Set userloginfos) {
		this.userloginfos = userloginfos;
	}

}