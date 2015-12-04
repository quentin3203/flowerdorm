package com.jxust.service.impl;

import com.jxust.dao.IOrderDAO;
import com.jxust.model.Orders;
import com.jxust.service.IOrderService;

public class OrderService implements IOrderService {
	private IOrderDAO orderDAO;

	@Override
	public Orders saveOrder(Orders order) {
		// TODO Auto-generated method stub
		return orderDAO.saveOrder(order);
	}

	public IOrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setOrderDAO(IOrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

}
