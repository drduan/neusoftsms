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
 * ��������̳������Ӧ���Ʋ�ĸ���
 * ������Ҫ������Ƹı�ָ���������ռ䣨namespace��
 * �Լ�resultsע��
 * @author Star
 *
 */
@Controller
@Lazy(true)
@ParentPackage("struts-default")
public abstract class BaseAction {

	private int msgState;

	/**
	 * ���ڹ���service��ָ����action ��Ҫʹ�õĻ���dao����
	 */
	private String key;

	/**
	 * ����springע���ȡmodelservice����
	 */
	@Resource(name = "modelService")
	private ModelService service;
	/**
	 * ��ҳ��ѯʱ�õ�ҳ��
	 */
	private int pageNum = 1;
	/**
	 * ��ҳ��ѯʱ��ָ��ҳ������Ĭ��10��
	 */
	private int rowCount = 10;
	/**
	 * ��ҳ��ѯʱ������ָ����������ر����Ϣ��ȡָ�������Է�ҳ��ҳ��
	 */
	private Integer pageCount = null;

	/**
	 * ǿ��ʵ��getkey��ϸ����װ��Ҫ���ṩ�����෽������
	 * 
	 * @return ���ڹ���service��ָ����action ��Ҫʹ�õĻ���dao����
	 */
	public abstract String getKey();

	/**
	 * �ж���ز�������ӻ��Ǹ��µı�ʶ
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
	 * ����ָ��������ȡ��ҳ��Ϣ��ѯ
	 * @return �����Ϣ
	 */
	@Action(value="getInfo")
	public String getInfo(){
		Map mp= (Map) ActionContext.getContext().get("request");
		mp.put("infoes", this.getService().getInfoByPageNum(getKey(), getPageNum(), getRowCount()));
		
		return "infoes";
	}
	
	
	/**
	 * ���ݲ�������ָ��ɾ��������ɾ��
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
	 * ���ݱ�ʶ��insertOrUpdate����ֵ������Ϣ��ӻ���µķ���
	 * @return
	 */
	@Action(value = "insertOrUpdate")
	public String insertOrUpdate() {
		// ���
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
		 * ��ȡ��ʦ��Ϣ���ݷ��ʹ��������Ĺؼ���
		 */
		String TEACHER = "teacherDAO";
		/**
		 * ��ȡѧ����Ϣ���ݷ��ʹ��������Ĺؼ���
		 */
		String STUDENT = "studentDAO";
		/**
		 * ��ȡ�༶��Ϣ���ݷ��ʹ��������Ĺؼ���
		 */
		String USERINFO = "userinfoDAO";
	}
}
