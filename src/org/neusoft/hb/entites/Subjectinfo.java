package org.neusoft.hb.entites;


/**
 * Subjectinfo entity. @author MyEclipse Persistence Tools
 */

public class Subjectinfo implements java.io.Serializable {

	// Fields

	private Integer subid;
	private String subname;
	// Constructors

	/** default constructor */
	public Subjectinfo() {
	}

	/** minimal constructor */
	public Subjectinfo(String subname) {
		this.subname = subname;
	}

	// Property accessors

	public Integer getSubid() {
		return this.subid;
	}

	public void setSubid(Integer subid) {
		this.subid = subid;
	}

	public String getSubname() {
		return this.subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	@Override
	public String toString() {
		return "Subjectinfo [subid=" + subid + ", subname=" + subname + "]";
	}

}