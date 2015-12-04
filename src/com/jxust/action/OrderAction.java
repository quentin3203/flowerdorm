package com.jxust.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import com.jxust.model.Orderitem;
import com.jxust.model.Orders;
import com.jxust.model.User;
import com.jxust.service.IOrderService;
import com.jxust.tool.Cart;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport {
	private IOrderService orderService;

	public IOrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}

	public String checkOut() {
		Map session = (Map) ActionContext.getContext().getSession();
		Cart cart = (Cart) session.get("cart");
		User user = (User) session.get("user");
		if (user == null) {
			return ERROR;
		}
		Orders order = new Orders();
		order.setOrderdate(new Timestamp(new Date().getTime()));
		for (Iterator iter = cart.getItems().values().iterator(); iter
				.hasNext();) {
			Orderitem orderitem = (Orderitem) iter.next();
			order.getOrderitems().add(orderitem);
			orderitem.setOrders(order);
		}
		orderService.saveOrder(order);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("order", order);
		session.remove("cart");
		return SUCCESS;
	}
}
