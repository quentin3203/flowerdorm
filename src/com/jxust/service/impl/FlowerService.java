package com.jxust.service.impl;

import java.util.List;

import com.jxust.dao.IFlowerDAO;
import com.jxust.model.Flower;
import com.jxust.service.IFlowerService;

public class FlowerService implements IFlowerService {
	private IFlowerDAO flowerDAO;

	@Override
	public List getNewFlower() {
		// TODO Auto-generated method stub
		return flowerDAO.getNewFlower();
	}

	public IFlowerDAO getFlowerDAO() {
		return flowerDAO;
	}

	public void setFlowerDAO(IFlowerDAO flowerDAO) {
		this.flowerDAO = flowerDAO;
	}

	@Override
	public int getTotalByCatalog(int catalogid) {
		// TODO Auto-generated method stub
		return flowerDAO.getTotalByCatalog(catalogid);
	}

	@Override
	public List getFlowerByCatalogidPaging(int catalogid, int currentPage,
			int pageSize) {
		// TODO Auto-generated method stub
		return flowerDAO.getFlowerByCatalogidPaging(catalogid, currentPage, pageSize);
	}

	@Override
	public Flower getFlowerById(int id) {
		// TODO Auto-generated method stub
		return flowerDAO.getFlowerById(id);
	}

	@Override
	public boolean addOrUpdateFlower(Flower flower) {
		// TODO Auto-generated method stub
		return flowerDAO.addOrUpdateFlower(flower);
	}

	@Override
	public List getAllFlower() {
		// TODO Auto-generated method stub
		return flowerDAO.getAllFlower();
	}

	@Override
	public boolean deleteFlowerById(int id) {
		// TODO Auto-generated method stub
		return flowerDAO.deleteFlowerById(id);
	}

}
