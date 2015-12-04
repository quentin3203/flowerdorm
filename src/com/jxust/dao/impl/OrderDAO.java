package com.jxust.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jxust.dao.IOrderDAO;
import com.jxust.model.Orders;

public class OrderDAO implements IOrderDAO {
	private SessionFactory sessionFactory;

	@Override
	public Orders saveOrder(Orders order) {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		session.save(order);
		ts.commit();
		session.close();
		return order;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
