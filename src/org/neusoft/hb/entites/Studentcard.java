package org.neusoft.hb.entites;

import java.util.Date;

/**
 * Studentcard entity. @author MyEclipse Persistence Tools
 */

public class Studentcard implements java.io.Serializable {

	// Fields

	private String stid;
	private Student student;
	private Date carddate;
	private Integer cardbg;

	// Constructors

	/** default constructor */
	public Studentcard() {
	}

	

	// Property accessors

	@Override
	public String toString() {
		return "Studentcard [stid=" + stid + ", student=" + student
				+ ", carddate=" + carddate + ", cardbg=" + cardbg + "]";
	}



	public String getStid() {
		return this.stid;
	}

	public void setStid(String stid) {
		this.stid = stid;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Date getCarddate() {
		return this.carddate;
	}

	public void setCarddate(Date carddate) {
		this.carddate = carddate;
	}

	public Integer getCardbg() {
		return this.cardbg;
	}

	public void setCardbg(Integer cardbg) {
		this.cardbg = cardbg;
	}

}