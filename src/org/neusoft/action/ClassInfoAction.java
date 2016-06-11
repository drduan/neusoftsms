package org.neusoft.action;

import java.io.Serializable;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.neusoft.hb.entites.Classinfo;
@Namespace(value = "/neusoft/crol/classinfoaction")
@Results(value = {
		@Result(name = "infoes", location = "/WEB-INF/infoes/info_classinfo.jsp"),
		@Result(name = "insert_or_update", location = "/WEB-INF/update/insertorupdate_classinfo.jsp") })
public class ClassInfoAction extends BaseAction {
	
	private Classinfo classinfo;
	
	private List<Classinfo> batch_list;
	
	
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return this.getService().CLASSINFO;
	}

	

	public Classinfo getClassinfo() {
		return classinfo;
	}



	public void setClassinfo(Classinfo classinfo) {
		this.classinfo = classinfo;
	}



	public List<Classinfo> getBatch_list() {
		return batch_list;
	}



	public void setBatch_list(List<Classinfo> batch_list) {
		this.batch_list = batch_list;
	}



	@Override
	public Serializable getEntity() {
		// TODO Auto-generated method stub
		return this.classinfo;
	}
	
	
	@Action(value = "toInsertOrUpdate")
	public String toInsertOrUpdate() {
		if (this.classinfo!=null&&this.classinfo.getClid()!=null) {
			this.classinfo=(Classinfo) getService().getInfoByID(getKey(), classinfo.getClid());
		}
		
		return "insert_or_update";
	}

}
