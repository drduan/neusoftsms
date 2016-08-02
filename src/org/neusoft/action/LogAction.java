package org.neusoft.action;

import java.io.Serializable;
import java.util.List;

import javax.imageio.spi.RegisterableService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.neusoft.hb.entites.Userinfo;

import com.opensymphony.xwork2.ActionContext;

@Namespace(value = "/neusoft/crol/logaction")
@Results(value = { @Result(name = "index", location = "/WEB-INF/index.html"),
		@Result(name = "login", location = "/login.jsp", params = { "msg", "${msg}" }) })

public class LogAction extends BaseAction {

	private Userinfo userinfo;
	private String msg;

	public Userinfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Action(value = "register")
	public String RegisterService() {
		
	
		
		
		
		try {
			getService().register(userinfo);
			ActionContext.getContext().getSession().put("user", userinfo);
		} catch (Exception e) {
			// TODO: handle exception
		}

		

		return "index";
	}

	@Action(value = "login")
	public String login() {

		userinfo = getService().login(userinfo);
		if (userinfo != null) {

			try {
				ActionContext.getContext().getSession().put("user", userinfo);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "index";
		} else {
			msg = "no";
			return "login";
		}
	}

	@Action(value = "exit")
	public String exit() {

		userinfo = (Userinfo) ActionContext.getContext().getSession().get("user");
		getService().exit(userinfo);
		msg = "exit";
		return "login";

	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getBatch_list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable getEntity() {
		// TODO Auto-generated method stub
		return null;
	}

}
