package org.neusoft.action;

import java.io.Serializable;
import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.neusoft.hb.entites.Student;
import org.neusoft.hb.entites.Studentcard;
@Namespace(value = "/neusoft/crol/studentcardaction")
@Results(value = {
		@Result(name = "infoes", location = "/WEB-INF/infoes/ info_studentcard.jsp"),


})
public class StudentCardAction extends BaseAction {

	private Studentcard studentcard;
	private List<Studentcard> batch_list;
	
	
	
	public Studentcard getStudentcard() {
		return studentcard;
	}

	public void setStudentcard(Studentcard studentcard) {
		this.studentcard = studentcard;
	}

	public void setBatch_list(List<Studentcard> batch_list) {
		this.batch_list = batch_list;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return getService().STUDENTCARD;
	}

	@Override
	public List getBatch_list() {
		// TODO Auto-generated method stub
		return batch_list;
	}

	@Override
	public Serializable getEntity() {
		// TODO Auto-generated method stub
		return this.studentcard;
	}

}
