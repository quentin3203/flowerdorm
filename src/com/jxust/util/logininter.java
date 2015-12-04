package com.jxust.util;

import java.util.Map;

import com.jxust.model.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class logininter extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		Map session = (Map) arg0.getInvocationContext().getSession();
		User user = (User) session.get("user");
		if (user == null) {
			return Action.LOGIN;
		}

		return arg0.invoke();
	}
}
