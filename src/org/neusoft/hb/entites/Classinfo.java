package org.neusoft.hb.entites;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Classinfo entity. @author MyEclipse Persistence Tools
 */

public class Classinfo implements java.io.Serializable {

	// Fields

	private String clid;
	private String clname;
	private Date clbegindate;
	private Date clenddate;

	// Constructors

	/** default constructor */
	public Classinfo() {
	}


	// Property accessors

	public String getClid() {
		return this.clid;
	}

	public void setClid(String clid) {
		this.clid = clid;
	}

	public String getClname() {
		return this.clname;
	}

	public void setClname(String clname) {
		this.clname = clname;
	}

	public Date getClbegindate() {
		return this.clbegindate;
	}

	public void setClbegindate(Date clbegindate) {
		this.clbegindate = clbegindate;
	}

	public Date getClenddate() {
		return this.clenddate;
	}

	public void setClenddate(Date clenddate) {
		this.clenddate = clenddate;
	}


	@Override
	public String toString() {
		return "Classinfo [clid=" + clid + ", clname=" + clname
				+ ", clbegindate=" + clbegindate + ", clenddate=" + clenddate
				+ "]";
	}


}