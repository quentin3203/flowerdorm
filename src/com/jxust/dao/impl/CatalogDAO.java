package com.jxust.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jxust.dao.ICatalogDAO;

public class CatalogDAO implements ICatalogDAO {
	private SessionFactory sessionFactory;

	@Override
	public List getAllCatalogs() {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Catalog");
		List catalogs = query.list();
		ts.commit();
		session.close();
		return catalogs;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
