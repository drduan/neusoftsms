package org.neusoft.hb.entites;

/**
 * StudentandsubjectId entity. @author MyEclipse Persistence Tools
 */

public class StudentandsubjectId implements java.io.Serializable {

	// Fields

	private Student student;
	
	private Subjectinfo subjectinfo;

	// Constructors

	/** default constructor */
	public StudentandsubjectId() {
	}

	/** full constructor */
	public StudentandsubjectId(Student student, Subjectinfo subjectinfo) {
		this.student = student;
		this.subjectinfo = subjectinfo;
	}

	// Property accessors

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subjectinfo getSubjectinfo() {
		return this.subjectinfo;
	}

	public void setSubjectinfo(Subjectinfo subjectinfo) {
		this.subjectinfo = subjectinfo;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StudentandsubjectId))
			return false;
		StudentandsubjectId castOther = (StudentandsubjectId) other;

		return ((this.getStudent() == castOther.getStudent()) || (this
				.getStudent() != null && castOther.getStudent() != null && this
				.getStudent().equals(castOther.getStudent())))
				&& ((this.getSubjectinfo() == castOther.getSubjectinfo()) || (this
						.getSubjectinfo() != null
						&& castOther.getSubjectinfo() != null && this
						.getSubjectinfo().equals(castOther.getSubjectinfo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getStudent() == null ? 0 : this.getStudent().hashCode());
		result = 37
				* result
				+ (getSubjectinfo() == null ? 0 : this.getSubjectinfo()
						.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "StudentandsubjectId [student=" + student + ", subjectinfo="
				+ subjectinfo + "]";
	}

	
}