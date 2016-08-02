package org.neusoft.mdservice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.Id;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.neusoft.hb.entites.Student;
import org.neusoft.hb.entites.Studentandsubject;
import org.neusoft.hb.entites.StudentandsubjectId;
import org.neusoft.hb.entites.Studentcard;
import org.neusoft.hb.entites.Subjectinfo;
import org.neusoft.hb.entites.Userinfo;
import org.neusoft.hb.entites.Userloginfo;
import org.neusoft.interfaces.DAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ModelService {

	public static final String TEACHER = "teacherDAO";
	public static final String CLASSINFO = "classInfoDAO";
	public static final String STUDENT = "studentDAO";
	public static final String SUBJECTINFO = "subjectinfoDAO";
	public static final String STUDENTCARD = "studentCardDAO";
	public static final String STUDENTANDSUBJECT = "studentAndSubjectDAO";
	public static final String USERINFO = "userInfoDAO";
	public static final String USERLOGINFO = "userLogInfoDAO";

	@Resource(name = "daoMap")
	private Map<String, DAO> daoMap;

	public Map<String, DAO> getDaoMap() {
		return daoMap;
	}

	public void setDaoMap(Map<String, DAO> daoMap) {
		this.daoMap = daoMap;
	}

	/**
	 * 根据dao 相关实现 进行的基本操作方法的封装
	 * 
	 * @param key
	 *            指定表格key（常量）
	 * @return
	 */

	// 获取表格所以信息
	public List getAll(String key) {
		return this.daoMap.get(key).getAll();
	}

	/**
	 * 根据主键编号返回指定信息
	 * 
	 * @param key
	 * @param id
	 *            主键编号
	 * @return 封装有相关数据的实体类对象
	 */

	public Object getInfoByID(String key, Serializable id) {
		return this.daoMap.get(key).getByID(id);
	}

	/**
	 * 根据提供的条件做相应查询获取信息的方法，并可以进行分页操作
	 * 
	 * @param key
	 *            指定表格的常量
	 * @param pageNum指定页面
	 * @param rowCount单页显示信息行数
	 * @param criterions查询条件
	 * @return封装有关信息实体类对象的list
	 */
	public List getInfoByProperties(String key, Integer pageNum,
			Integer rowCount, Criterion... criterions) {
		return this.daoMap.get(key).getInfosByProperties(pageNum, rowCount,
				criterions);

	}

	/**
	 * 根据提供的条件做相应查询获取信息的方法
	 * 
	 * @param key
	 *            指定表格的常量
	 * @param criterions查询条件
	 * @return封装有关信息实体类对象的list
	 */
	public List getInfoByProperties(String key, Criterion... criterions) {
		return this.daoMap.get(key).getInfosByProperties(criterions);

	}

	/**
	 * 对指定表格进行批量数据添加的方法
	 * 
	 * @param key
	 *            指定表格key常量
	 * @param entities
	 *            根据hibernate规范和业务需要封装有关数据的实体对象
	 */
	public void insert_batch(String key, Object... entities) {
		this.daoMap.get(key).excute_insert(entities);
	}

	/**
	 * 对指定表格进行批量数据删除的方法
	 * 
	 * @param key
	 *            指定表格key常量
	 * @param entities
	 *            根据hibernate规范和业务需要封装有关数据的实体对象
	 */
	public void delete_batch(String key, Object... entities) {
		this.daoMap.get(key).excute_delete(entities);
	}

	/**
	 * 对指定表格进行批量数据更改的方法
	 * 
	 * @param key
	 *            指定表格key常量
	 * @param entities
	 *            根据hibernate规范和业务需要封装有关数据的实体对象
	 */
	public void update_batch(String key, Object... entities) {
		this.daoMap.get(key).excute_update(entities);
	}
	/**
	 * 根据每一页行数得到指定表格信息可以分成的页数
	 * @param type 指定表格
	 * @param rowCount指定每页行数
	 * @return 可分页的数量
	 */
	public int getPageCount(String type,int rowCount){
		
		return this.daoMap.get(type).getPageCountByRowCount(rowCount);
	}
	
	//根据dao   相关实现      进行的            业务需要 方法
	/**
	 * 根据分页操作获取指定表格信息
	 * @param type 指定表格
	 * @param pageNum 指定页码
	 * @param rowCount 指定每页显示行数
	 * @return 查询结果
	 */
	public List getInfoByPageNum(String type,int pageNum,int rowCount){
		
		return this.getInfoByProperties(type, pageNum, rowCount);
	}
	/**
	 * 根据指定学生信息获取其当前选修的课程
	 * @param student 指定学生信息（要求分装有主键编号）
	 * @return 当前选修的课程
	 */
	public List<Studentandsubject> getSubjectByStudent(Student student){
		
		Criterion c1 = Restrictions.eq("id.student", student);
		List<Studentandsubject> infoes = daoMap.get(STUDENTANDSUBJECT).getInfosByProperties(c1);
		return infoes;
	}
	public boolean subjectToUpdate(Student student,Subjectinfo...subjectinfos){
		
		List<Studentandsubject> al= this.getSubjectByStudent(student);
		if (al!=null&&al.size()>0) {
			daoMap.get(STUDENTANDSUBJECT).excute_delete(al.toArray());

		}
		al.clear();
		
		if (subjectinfos!=null&&subjectinfos.length>0) {
			for (int i = 0; i < subjectinfos.length; i++) {
				Studentandsubject bean=new Studentandsubject();
				bean.setId(new StudentandsubjectId(student,subjectinfos[i]));
				al.add(bean);
			}
			daoMap.get(STUDENTANDSUBJECT).excute_insert(al.toArray());
			
		}
		return true;
	}
	
	public Userinfo login(Userinfo user){
		Criterion c1 = Restrictions.and(Restrictions.eq("logname", user.getLogname()), Restrictions.eq("keyword", user.getKeyword()));
		List<Userinfo> infoes = daoMap.get(USERINFO).getInfosByProperties(c1);
		
		if (infoes!=null&&infoes.size()==1) {
			Userinfo userinfo = infoes.get(0);
			Userloginfo userloginfo = new Userloginfo(userinfo, new Date(),new Integer(1));
//			daoMap.get(USERLOGINFO).excute_insert(userloginfo);
			return userinfo;
		}
		
		return null;
	}
	
	
	public Userinfo register(Userinfo user){
		
		System.out.println("@@"+user.getKeyword()+user.getLogname()+"@@");
		
		try{
		daoMap.get(USERLOGINFO).excute_insert(user);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}
	
	
	
	public void exit(Userinfo user){
		Userloginfo userloginfo = new Userloginfo(user,new Date(),new Integer(2));
//		daoMap.get(USERLOGINFO).excute_insert(userloginfo);
	}
	
	
	
	public boolean detelet_Student_clear(Student...students){
		DAO dao_car = daoMap.get(STUDENT);
		
		List<Studentandsubject> list_sas=new ArrayList<Studentandsubject>();
		List<Studentcard> list_card=new ArrayList<Studentcard>();
		
		for (Student student : students) {
			list_card.add((Studentcard) dao_car.getByID(student.getStid()));
			list_sas.addAll(getSubjectByStudent(student));
			
		}
		delete_batch(STUDENTANDSUBJECT, list_sas.toArray());
		delete_batch(STUDENTCARD, list_card.toArray());
		delete_batch(STUDENT, students);
		return true;
	}
}

