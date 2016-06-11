package org.neusoft.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.junit.BeforeClass;
import org.junit.Test;
import org.neusoft.hb.entites.Student;
import org.neusoft.hb.entites.Studentandsubject;
import org.neusoft.hb.entites.Teacher;
import org.neusoft.interfaces.DAO;
import org.neusoft.mdservice.ModelService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import freemarker.ext.beans.BeansWrapper;

public class TestUnit {

	private static ApplicationContext app;

	@BeforeClass
	public static void before() {
		app = new ClassPathXmlApplicationContext("app1.xml");
	}

	@Test
	public void test1() throws SQLException {
		// 连接数据库
		// DataSource dts = (DataSource) app.getBean("dataSource");
		// System.out.println(dts.getConnection());
		// 创建session
		// SessionFactory factory = (SessionFactory)
		// app.getBean("sessionFactory");
		// System.out.println(factory.openSession());
	}

	@Test
	public void test2() {
		DAO<Teacher> dao = (DAO<Teacher>) app.getBean("teacherDAO");
		// List<Teacher> al = dao.getAll();
		// for (Teacher teacher : al) {
		// System.out.println(teacher);
		// }

		// Teacher teacher= dao.getByID(1);
		// System.out.println(teacher);
		
		//查询名字带“子”年龄大于32的
//		Criterion criterion = Restrictions.and(
//				Restrictions.like("tname", "%子%"), Restrictions.gt("tage", 32));
//		List<Teacher> al = dao.getInfosByProperties(criterion);
//		for (Teacher teacher : al) {
//			System.out.println(teacher);
//		}
//
//		Teacher teacher = new Teacher("李旭晨",40);
//		Teacher teacher2 = new Teacher("李旭",50);
//		Teacher teacher3= new Teacher("李晨",350);
//		Teacher teacher4 = new Teacher("李旭东",40);
//		Teacher teacher5 = new Teacher("李杰晨",40);
//		dao.excute_insert(teacher,teacher2,teacher3,teacher4,teacher5);
//更改
//		Teacher teacher = new Teacher(10, "李旭晨", 44);
//		dao.excute_update(teacher);
//删除
		
	}
	@Test
	public void testStudent(){
		//DAO<Student> dao = (DAO<Student>) app.getBean("studentDAO");
		//List<Student> al = dao.getAll();
//		List<Student> al=dao.getInfosByProperties(3, 5);
//		for (Student student : al) {
//			System.out.println(student);
//		}
//		
//		Student student = dao.getByID("st_1");
//		System.out.println(student.getStname());
//		System.out.println(student.getStudentcard().getStudent());
	
//	ModelService md= (ModelService) app.getBean("modelService");
//	List<Student> list= md.getInfoByPageNum(md.STUDENT, 1, 6);
//	for (Student student : list) {
//		System.out.println(student);
//	}
		
//		int ps = dao.getPageCountByRowCount(10);
//		System.out.println(ps);
//		
	}
	
	@Test
	public void testOfStudentAndSubject(){
//		ModelService service = (ModelService) app.getBean("modelService");
//		Student student = new Student();
//		student.setStid("st_01");
//		List<Studentandsubject> alList = service.getSubjectByStudent(student);
//		for (Studentandsubject studentandsubject : alList) {
//			System.out.println(studentandsubject);
//		}
//		
	}
	
	@Test
	public void TestADB(){
		
		
//		LinkedList<String> aLinkedList = new LinkedList<>();
//		aLinkedList.add("asd");
//		aLinkedList.add(2, "a");

		// char[] data={?a?,'b?,'c?,'d?};
		//
		// System.out.println(String.valueOf(10D));
		//
		// System.out.println(String.valueOf(3>2));
		//
		// System.out.println(String.valueOf(data,1,0));


		
		
	}
	
}
