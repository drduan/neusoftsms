package org.neusoft.action;

import java.io.Serializable;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.neusoft.hb.entites.Classinfo;
import org.neusoft.hb.entites.Student;
import org.neusoft.hb.entites.Subjectinfo;
@Namespace(value = "/neusoft/crol/subjectinfoaction")
@Results(value = {
		@Result(name = "infoes", location = "/WEB-INF/infoes/info_subjectinfo.jsp"),
		@Result(name = "insert_or_update", location = "/WEB-INF/update/insertorupdate_subjectinfo.jsp")

})
public class SubjectInfoAction extends BaseAction {

	private Subjectinfo subjectinfo;
	private List<Subjectinfo> batch_list;
	
	
	
	public Subjectinfo getSubjectinfo() {
		return subjectinfo;
	}

	public void setSubjectinfo(Subjectinfo subjectinfo) {
		this.subjectinfo = subjectinfo;
	}

	public void setBatch_list(List<Subjectinfo> batch_list) {
		this.batch_list = batch_list;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return getService().SUBJECTINFO;
	}

	@Override
	public List getBatch_list() {
		// TODO Auto-generated method stub
		return batch_list;
	}

	@Override
	public Serializable getEntity() {
		// TODO Auto-generated method stub
		return this.subjectinfo;
	}
	
	
	@Action(value = "toInsertOrUpdate")
	public String toInsertOrUpdate() {
		if (this.subjectinfo!=null&&this.subjectinfo.getSubid()!=null) {
			this.subjectinfo=(Subjectinfo) getService().getInfoByID(getKey(), subjectinfo.getSubid());
		}
		
		return "insert_or_update";
	}
	

}
