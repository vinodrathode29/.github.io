package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {

	public static void main(String[] args) throws CartEmptyException {
		testGetAllCartItems();
		testAddCartItem();
		testGetAllCartItems();
		testRemoveCartItem();
		testGetAllCartItems();

	}

	public static void testAddCartItem() throws CartEmptyException {
		CartDao cartDao = new CartDaoCollectionImpl();

		cartDao.addCartItem(1, 4L);
		cartDao.addCartItem(1, 3L);

		List<MenuItem> menuItemListCustomer = cartDao.getAllCartItems(1);
		System.out.println("User Added Cart List for CheckOut");
		for (MenuItem menuItem : menuItemListCustomer) {
			System.out.println(menuItem);
		}
	}

	public static void testGetAllCartItems() throws CartEmptyException {

		CartDao cartDao = new CartDaoCollectionImpl();
		try {
			List<MenuItem> menuItemListCustomer = cartDao.getAllCartItems(1);
			System.out.println("Cart Items List Of User");

			for (MenuItem menuItem : menuItemListCustomer) {

				System.out.println(menuItem);
			}
		} catch (CartEmptyException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void testRemoveCartItem() throws CartEmptyException {
		CartDao cartDao = new CartDaoCollectionImpl();
		System.out.println("Customer Item List for after Remove");
		try {
			cartDao.removeCartItem(1, 4L);
			// cartDao.removeCartItem(1, 3L);

			List<MenuItem> menuItemListCustomer = cartDao.getAllCartItems(1);
			for (MenuItem menuItem : menuItemListCustomer) {
				System.out.println(menuItem);
			}
		} catch (CartEmptyException e) {
			System.out.println(e.getMessage());
		}
	}

}
