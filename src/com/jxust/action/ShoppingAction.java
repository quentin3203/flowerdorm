package com.jxust.action;

import java.util.Map;

import com.jxust.model.Flower;
import com.jxust.model.Orderitem;
import com.jxust.service.IFlowerService;
import com.jxust.tool.Cart;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShoppingAction extends ActionSupport {
	private int id;
	private int quantity;
	private IFlowerService flowerService;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public IFlowerService getFlowerService() {
		return flowerService;
	}

	public void setFlowerService(IFlowerService flowerService) {
		this.flowerService = flowerService;
	}

	public String addToCart() {
		Flower flower = flowerService.getFlowerById(id);
		Orderitem orderitem = new Orderitem();
		orderitem.setFlower(flower);
		orderitem.setQuantity(quantity);
		Map session = (Map) ActionContext.getContext().getSession();
		Cart cart = (Cart) session.get("cart");
		if (cart == null) {
			cart = new Cart();
		}
		cart.addFlower(id, orderitem);
		session.put("cart", cart);
		return SUCCESS;

	}

	public String updateCart() {
		Map session = (Map) ActionContext.getContext().getSession();
		Cart cart = (Cart) session.get("cart");
		cart.updateCart(id, quantity);
		session.put("cart", cart);
		return SUCCESS;
	}

	public String checkOut() {
		Map session = (Map) ActionContext.getContext().getSession();
		Cart cart = (Cart) session.get("cart");
		cart.updateCart(id, quantity);
		session.put("cart", cart);
		return SUCCESS;
	}
}
