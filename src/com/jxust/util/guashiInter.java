package com.jxust.util;

import java.util.List;
import java.util.Map;

import com.jxust.action.UserAction;
import com.jxust.model.Guashi;
import com.jxust.service.IUserService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class guashiInter extends AbstractInterceptor {
	private IUserService userService;

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		UserAction userAction = (com.jxust.action.UserAction) arg0.getAction();
		String username = userAction.getUser().getUsername();
		List list = userService.getGuashi();
		for (int i = 0; i < list.size(); i++) {
			if (((Guashi) list.get(i)).getUser().getUsername().equals(username)) {
				System.out.println(((Guashi) list.get(i)).getUser()
						.getUsername().equals(username));
				Map request = (Map) arg0.getInvocationContext().get("request");
				request.put("msg", "ÕËºÅÒÑ¹ÒÊ§£¡");
				return Action.ERROR;
			}

		}
		return arg0.invoke();
	}

}
