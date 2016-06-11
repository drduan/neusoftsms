package org.neusoft.interfaces;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;


/**
 * 基于规范进行设计的DAO接口
 * @author Star
 *
 * @param <T>
 */
public interface DAO<T> {
	
	/**
	 * 获取相关表格全部信息
	 * @return封装有相关信息的实体类对象的list
	 */
	List<T> getAll();
	
	/**
	 * 根据指定主键获取指定信息封装对象
	 * @param id主键信息
	 * @return封装有相关数据的实体类对象
	 */
	T getByID(Serializable id);
	
	/**
	 * 根据业务需要，进行多条件查询的方法
	 * @param criterions 查询条件
	 * @return封装有相关数据的实体类对象list
	 */
	List<T> getInfosByProperties(Criterion...criterions);
	
	/**
	 * 根据业务需要进行多条件查询，并实现分页
	 * @param pageNum要查询的页码
	 * @param rowCount指定每页显示的行数
	 * @param criterions查询条件
	 * @return封装有相关数据的实体类对象list
	 */
	List<T> getInfosByProperties(Integer pageNum,Integer rowCount,Criterion...criterions);
	
	/**
	 * 批量进行相关数据添加的方法
	 * @param ts封装有数据的n个实体类对象
	 */
	void excute_insert(T...ts);
	
	/**
	 * 批量进行相关数据删除的方法
	 * @param ts封装有数据的n个实体类对象
	 */
	void excute_delete(T...ts);
	
	/**
	 * 批量进行相关数据更新的方法
	 * @param ts封装有数据的n个实体类对象
	 */
	void excute_update(T...ts);
	
	/**
	 * 根据每页行数，得到相关表格可以分成几页的方法
	 * @param rowCount每页行数
	 * @return 页数
	 */
	int getPageCountByRowCount(int rowCount);
}
