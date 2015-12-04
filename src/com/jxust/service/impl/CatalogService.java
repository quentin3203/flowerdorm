package com.jxust.service.impl;

import java.util.List;

import com.jxust.dao.ICatalogDAO;
import com.jxust.service.ICatalogService;

public class CatalogService implements ICatalogService {
	private ICatalogDAO catalogDAO;

	@Override
	public List getAllCatalogs() {
		// TODO Auto-generated method stub
		return catalogDAO.getAllCatalogs();
	}

	public ICatalogDAO getCatalogDAO() {
		return catalogDAO;
	}

	public void setCatalogDAO(ICatalogDAO catalogDAO) {
		this.catalogDAO = catalogDAO;
	}

}
