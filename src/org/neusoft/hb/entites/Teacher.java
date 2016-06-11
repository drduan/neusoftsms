package org.neusoft.hb.entites;

/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */

public class Teacher implements java.io.Serializable {

	// Fields

	private Integer tid;
	private String tname;
	private Integer tage;

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	public Teacher(Integer tid, String tname, Integer tage) {
		this.tid = tid;
		this.tname = tname;
		this.tage = tage;
	}

	/** minimal constructor */
	public Teacher(String tname) {
		this.tname = tname;
	}

	/** full constructor */
	public Teacher(String tname, Integer tage) {
		this.tname = tname;
		this.tage = tage;
	}

	// Property accessors


	public Integer getTid() {
		return this.tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getTname() {
		return this.tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Integer getTage() {
		return this.tage;
	}

	public void setTage(Integer tage) {
		this.tage = tage;
	}

	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tname=" + tname + ", tage=" + tage
				+ "]";
	}

	
}