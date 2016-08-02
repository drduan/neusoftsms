package org.neusoft.action;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.neusoft.hb.entites.Student;
import org.neusoft.mdservice.ModelService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
/**
 * 用于子类继承设计相应控制层的父类
 * 子类需要根据设计改变指定的命名空间（namespace）
 * 以及results注释
 * @author Star
 *
 */
@Controller
@Lazy(true)
@ParentPackage("struts-default")
public abstract class BaseAction {

	private int msgState;

	/**
	 * 用于关联service以指定本action 需要使用的基本dao对象
	 */
	private String key;

	/**
	 * 依赖spring注入获取modelservice对象
	 */
	@Resource(name = "modelService")
	private ModelService service;
	/**
	 * 分页查询时用的页码
	 */
	private int pageNum = 1;
	/**
	 * 分页查询时，指定页行数，默认10行
	 */
	private int rowCount = 10;
	/**
	 * 分页查询时，根据指定行数和相关表格信息获取指定表格可以分页的页数
	 */
	private Integer pageCount = null;

	/**
	 * 强制实现getkey结合父类封装需要，提供给子类方法是用
	 * 
	 * @return 用于关联service以指定本action 需要使用的基本dao对象
	 */
	public abstract String getKey();

	/**
	 * 判读相关操作是添加还是更新的标识
	 */
	private String insertOrUpdate;

	public String getInsertOrUpdate() {
		return insertOrUpdate;
	}

	public void setInsertOrUpdate(String insertOrUpdate) {
		this.insertOrUpdate = insertOrUpdate;
	}

	public int getPageCount() {
		if (pageCount == null) {

			pageCount = this.getService().getPageCount(getKey(),
					this.getRowCount());

		}
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
		if (this.pageNum < 1) {
			this.pageNum = 1;
		}
		if (this.pageNum > this.getPageCount()) {
			this.pageNum = this.getPageCount();
		}
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getMsgState() {
		return msgState;
	}

	public void setMsgState(int msgState) {
		this.msgState = msgState;
	}

	public ModelService getService() {
		return service;
	}

	public void setService(ModelService service) {
		this.service = service;
	}

	public abstract List getBatch_list() ;
	public abstract Serializable getEntity();
	// ====================================================
	/**
	 * 根据指定操作获取分页信息查询
	 * @return 相关信息
	 */
	@Action(value="getInfo")
	public String getInfo(){
		Map mp= (Map) ActionContext.getContext().get("request");
		mp.put("infoes", this.getService().getInfoByPageNum(getKey(), getPageNum(), getRowCount()));
		
		return "infoes";
	}
	
	
	/**
	 * 根据操作进行指定删除或批量删除
	 * @return
	 */
	@Action(value = "delete")
	public String delete_info() {

		// System.out.println(batch_list);
		if (getBatch_list()!= null && getBatch_list().size() > 0) {
			this.getService().delete_batch(getKey(), getBatch_list().toArray());
		} else if (getEntity() != null) {
			this.getService().delete_batch(getKey(), getEntity());
		}

		return getInfo();
	}
	/**
	 * 根据标识（insertOrUpdate）的值进行信息添加或更新的方法
	 * @return
	 */
	@Action(value = "insertOrUpdate")
	public String insertOrUpdate() {
		// 添加
		if ("insert1".equals(this.getInsertOrUpdate())) {
			getService().insert_batch(getKey(), getEntity());
		} else {
			getService().update_batch(getKey(), getEntity());
		}

		return getInfo();
	}
	
	// ====================================================
	public interface ServiceHelper {
		/**
		 * 获取讲师信息数据访问工具类对象的关键字
		 */
		String TEACHER = "teacherDAO";
		/**
		 * 获取学生信息数据访问工具类对象的关键字
		 */
		String STUDENT = "studentDAO";
		/**
		 * 获取班级信息数据访问工具类对象的关键字
		 */
		String USERINFO = "userinfoDAO";
	}
}
