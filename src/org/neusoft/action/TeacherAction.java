package org.neusoft.action;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.neusoft.hb.entites.Classinfo;
import org.neusoft.hb.entites.Student;
import org.neusoft.hb.entites.Teacher;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

@Namespace(value = "/neusoft/crol/teacheraction")
@Results(value = {
		@Result(name = "infoes", location = "/WEB-INF/infoes/info_teacher.jsp"),
		@Result(name = "insert_or_update", location = "/WEB-INF/update/insert_teacher.jsp") })
public class TeacherAction extends BaseAction {
	
	private Teacher teacher;
	private List<Teacher> batch_list;
	

	public void setBatch_list(List<Teacher> batch_list) {
		this.batch_list = batch_list;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return getService().TEACHER;
	}

	@Override
	public List getBatch_list() {
		// TODO Auto-generated method stub
		return batch_list;
	}

	
	public Serializable getEntity() {
		// TODO Auto-generated method stub
		return this.teacher;
	}

	@Action(value = "toInsertOrUpdate")
	public String toInsertOrUpdate() {
		if (teacher != null && teacher.getTid() != null) {
			this.teacher = (Teacher) getService().getInfoByID(getKey(),
					teacher.getTid());
		}

		List<Teacher> infoes = this.getService().getAll(
				getService().TEACHER);
		Map<String, Object> mp = (Map<String, Object>) ActionContext
				.getContext().get("request");
		mp.put("infoes", infoes);
		return "insert_or_update";
	}

}
