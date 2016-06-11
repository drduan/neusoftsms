package org.neusoft.mdservice;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.Id;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.neusoft.hb.entites.Student;
import org.neusoft.hb.entites.Studentandsubject;
import org.neusoft.hb.entites.Subjectinfo;
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

	@Resource(name = "daoMap")
	private Map<String, DAO> daoMap;

	public Map<String, DAO> getDaoMap() {
		return daoMap;
	}

	public void setDaoMap(Map<String, DAO> daoMap) {
		this.daoMap = daoMap;
	}

	/**
	 * ����dao ���ʵ�� ���еĻ������������ķ�װ
	 * 
	 * @param key
	 *            ָ������key��������
	 * @return
	 */

	// ��ȡ����������Ϣ
	public List getAll(String key) {
		
		System.out.println("daoMap.get"+daoMap.get(key));
		
		return this.daoMap.get(key).getAll();
		
	}

	/**
	 * ����������ŷ���ָ����Ϣ
	 * 
	 * @param key
	 * @param id
	 *            �������
	 * @return ��װ��������ݵ�ʵ�������
	 */

	public Object getInfoByID(String key, Serializable id) {
		return this.daoMap.get(key).getByID(id);
	}

	/**
	 * �����ṩ����������Ӧ��ѯ��ȡ��Ϣ�ķ����������Խ��з�ҳ����
	 * 
	 * @param key
	 *            ָ������ĳ���
	 * @param pageNumָ��ҳ��
	 * @param rowCount��ҳ��ʾ��Ϣ����
	 * @param criterions��ѯ����
	 * @return��װ�й���Ϣʵ��������list
	 */
	public List getInfoByProperties(String key, Integer pageNum,
			Integer rowCount, Criterion... criterions) {
		return this.daoMap.get(key).getInfosByProperties(pageNum, rowCount,
				criterions);

	}

	/**
	 * �����ṩ����������Ӧ��ѯ��ȡ��Ϣ�ķ���
	 * 
	 * @param key
	 *            ָ������ĳ���
	 * @param criterions��ѯ����
	 * @return��װ�й���Ϣʵ��������list
	 */
	public List getInfoByProperties(String key, Criterion... criterions) {
		return this.daoMap.get(key).getInfosByProperties(criterions);

	}

	/**
	 * ��ָ��������������������ӵķ���
	 * 
	 * @param key
	 *            ָ������key����
	 * @param entities
	 *            ����hibernate�淶��ҵ����Ҫ��װ�й����ݵ�ʵ�����
	 */
	public void insert_batch(String key, Object... entities) {
		this.daoMap.get(key).excute_insert(entities);
	}

	/**
	 * ��ָ�����������������ɾ���ķ���
	 * 
	 * @param key
	 *            ָ������key����
	 * @param entities
	 *            ����hibernate�淶��ҵ����Ҫ��װ�й����ݵ�ʵ�����
	 */
	public void delete_batch(String key, Object... entities) {
		this.daoMap.get(key).excute_delete(entities);
	}

	/**
	 * ��ָ����������������ݸ��ĵķ���
	 * 
	 * @param key
	 *            ָ������key����
	 * @param entities
	 *            ����hibernate�淶��ҵ����Ҫ��װ�й����ݵ�ʵ�����
	 */

	public void update_batch(String key, Object... entities) {
		this.daoMap.get(key).excute_update(entities);
	}
	/**
	 * ����ÿһҳ�����õ�ָ��������Ϣ���Էֳɵ�ҳ��
	 * @param type ָ������
	 * @param rowCountָ��ÿҳ����
	 * @return �ɷ�ҳ������
	 */
	public int getPageCount(String type,int rowCount){
		
		return this.daoMap.get(type).getPageCountByRowCount(rowCount);
	}
	
	//����dao   ���ʵ��      ���е�            ҵ����Ҫ ����
	/**
	 * ���ݷ�ҳ������ȡָ��������Ϣ
	 * @param type ָ������
	 * @param pageNum ָ��ҳ��
	 * @param rowCount ָ��ÿҳ��ʾ����
	 * @return ��ѯ���
	 */
	public List getInfoByPageNum(String type,int pageNum,int rowCount){
		
		return this.getInfoByProperties(type, pageNum, rowCount);
	}
	/**
	 * ����ָ��ѧ����Ϣ��ȡ�䵱ǰѡ�޵Ŀγ�
	 * @param student ָ��ѧ����Ϣ��Ҫ���װ��������ţ�
	 * @return ��ǰѡ�޵Ŀγ�
	 */
	public List<Studentandsubject> getSubjectByStudent(Student student){
		
		Criterion c1 = Restrictions.eq("id.student", student);
		List<Studentandsubject> infoes = daoMap.get(STUDENTANDSUBJECT).getInfosByProperties(c1);
		return infoes;
	}
}