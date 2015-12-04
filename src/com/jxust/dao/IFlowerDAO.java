package com.jxust.dao;

import java.util.List;

import com.jxust.model.Flower;

public interface IFlowerDAO {
	public List getNewFlower();
	public List getFlowerByCatalogidPaging(int catalogid,int currentPage,int pageSize);
	public int getTotalByCatalog(int catalogid);
	public Flower getFlowerById(int id); 
	public boolean addOrUpdateFlower(Flower flower);
	public List getAllFlower();
	public boolean deleteFlowerById(int id);
}
