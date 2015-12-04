package com.jxust.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.jxust.dao.IFlowerDAO;
import com.jxust.model.Flower;

public class FlowerDAO implements IFlowerDAO {
	private SessionFactory sessionFactory;

	@Override
	public List getNewFlower() {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Flower order by flowerid desc");
		query.setFirstResult(0);
		query.setMaxResults(4);
		List flowers = query.list();
		ts.commit();
		session.close();
		return flowers;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public int getTotalByCatalog(int catalogid) {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Flower where catalogid="
				+ catalogid);
		List flowers = query.list();
		session.close();
		return flowers.size();
	}

	@Override
	public List getFlowerByCatalogidPaging(int catalogid, int currentPage,
			int pageSize) {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Flower where catalogid="
				+ catalogid);
		int startRow = (currentPage - 1) * pageSize;
		query.setFirstResult(startRow);
		query.setMaxResults(pageSize);
		List flowers = query.list();
		session.close();
		return flowers;

	}

	@Override
	public Flower getFlowerById(int id) {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Flower where flowerid=" + id);
		List flowers = query.list();
		session.close();
		return (Flower) flowers.get(0);
	}

	@Override
	public boolean addOrUpdateFlower(Flower flower) {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		session.saveOrUpdate(flower);
		session.flush();
		session.clear();
		ts.commit();
		session.close();
		return true;
	}

	@Override
	public List getAllFlower() {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session
				.createQuery("from Flower order by catalogid desc");
		List flowers = query.list();
		session.flush();
		session.clear();
		ts.commit();
		session.close();
		return flowers;
	}

	@Override
	public boolean deleteFlowerById(int id) {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Flower where flowerid=" + id);
		Flower flower = (Flower) query.list().get(0);
		session.delete(flower);
		ts.commit();
		session.close();

		return true;
	}

}
