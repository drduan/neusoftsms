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
import org.neusoft.hb.entites.Studentandsubject;
import org.neusoft.hb.entites.Subjectinfo;
import org.neusoft.hb.entites.Teacher;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;


@Namespace(value = "/neusoft/crol/studentaction")
@Results(value = {
		@Result(name = "infoes", location = "/WEB-INF/infoes/info_student.jsp"),
		@Result(name = "insert_or_update", location = "/WEB-INF/update/insert_student.jsp"),
		@Result(name = "student_subject", location = "/WEB-INF/subject/student_subject.jsp") 
})
public class StudentAction extends BaseAction {

//	Teacher aTeacher = new Teacher().get
	private Student student;
	private List<Student> batch_list;

	
	

	public void setBatch_list(List<Student> batch_list) {
		this.batch_list = batch_list;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}


	@Action(value = "toInsertOrUpdate")
	public String toInsertOrUpdate() {
		if (student != null && student.getStid() != null) {
			this.student = (Student) getService().getInfoByID(getKey(),
					student.getStid());
		}

		List<Classinfo> infoes = this.getService().getAll(
				getService().CLASSINFO);
		Map<String, Object> mp = (Map<String, Object>) ActionContext
				.getContext().get("request");
		mp.put("infoes", infoes);
		return "insert_or_update";
	}
	@Action(value="toSubject")
	public String toSubject(){
		student = (Student) getService().getInfoByID(getKey(), student.getStid());
		//问题代码
		//是学生信息里的课程选修
		try {
			List<Subjectinfo> subjects_all = this.getService().getAll(getService().SUBJECTINFO);
			
			List<Studentandsubject> subjects_now = getService().getSubjectByStudent(student);
			Map<String, Object> mp= (Map<String, Object>) ActionContext.getContext().get("request");
			mp.put("subjects_all", subjects_all);
			mp.put("subjects_now", subjects_now);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
//	
		return "student_subject";
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return getService().STUDENT;
	}

	@Override
	public List getBatch_list() {
		// TODO Auto-generated method stub
		return batch_list;
	}

	public Serializable getEntity() {
		// TODO Auto-generated method stub
		return this.student;
	}
}
