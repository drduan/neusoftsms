package org.neusoft.hb.entites;

/**
 * Studentandsubject entity. @author MyEclipse Persistence Tools
 */

public class Studentandsubject implements java.io.Serializable {

	// Fields
	private StudentandsubjectId id;

	// Constructors

	/** default constructor */
	public Studentandsubject() {
	}

	/** full constructor */
	public Studentandsubject(StudentandsubjectId id) {
		this.id = id;
	}

	// Property accessors

	public StudentandsubjectId getId() {
		return this.id;
	}

	public void setId(StudentandsubjectId id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Studentandsubject [id=" + id + "]";
	}

	

	
}