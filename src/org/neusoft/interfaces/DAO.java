package org.neusoft.interfaces;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;


/**
 * ���ڹ淶������Ƶ�DAO�ӿ�
 * @author Star
 *
 * @param <T>
 */
public interface DAO<T> {
	
	/**
	 * ��ȡ��ر��ȫ����Ϣ
	 * @return��װ�������Ϣ��ʵ��������list
	 */
	List<T> getAll();
	
	/**
	 * ����ָ��������ȡָ����Ϣ��װ����
	 * @param id������Ϣ
	 * @return��װ��������ݵ�ʵ�������
	 */
	T getByID(Serializable id);
	
	/**
	 * ����ҵ����Ҫ�����ж�������ѯ�ķ���
	 * @param criterions ��ѯ����
	 * @return��װ��������ݵ�ʵ�������list
	 */
	List<T> getInfosByProperties(Criterion...criterions);
	
	/**
	 * ����ҵ����Ҫ���ж�������ѯ����ʵ�ַ�ҳ
	 * @param pageNumҪ��ѯ��ҳ��
	 * @param rowCountָ��ÿҳ��ʾ������
	 * @param criterions��ѯ����
	 * @return��װ��������ݵ�ʵ�������list
	 */
	List<T> getInfosByProperties(Integer pageNum,Integer rowCount,Criterion...criterions);
	
	/**
	 * �����������������ӵķ���
	 * @param ts��װ�����ݵ�n��ʵ�������
	 */
	void excute_insert(T...ts);
	
	/**
	 * ���������������ɾ���ķ���
	 * @param ts��װ�����ݵ�n��ʵ�������
	 */
	void excute_delete(T...ts);
	
	/**
	 * ��������������ݸ��µķ���
	 * @param ts��װ�����ݵ�n��ʵ�������
	 */
	void excute_update(T...ts);
	
	/**
	 * ����ÿҳ�������õ���ر����Էֳɼ�ҳ�ķ���
	 * @param rowCountÿҳ����
	 * @return ҳ��
	 */
	int getPageCountByRowCount(int rowCount);
}
