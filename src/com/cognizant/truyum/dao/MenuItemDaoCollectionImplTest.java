package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {
	public static void main(String[] arg) {
		try {
			System.out.println("================Admin List====================");
			testGetMenuItemListAdmin();
			System.out.println("================Customer List====================");
			testGetMenuItemListCustomer();
			System.out.println("================Modified List====================");
			testModifyMenuItem();
			testGetMenuItemListAdmin();
		} catch (ParseException e) {

		}
	}

	public static void testGetMenuItemListAdmin() throws ParseException {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();

		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();
		for (MenuItem x : menuItemList) {

			System.out.println(x);
		}
	}

	public static void testGetMenuItemListCustomer() throws ParseException {

		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();

		List<MenuItem> customerList = menuItemDao.getMenuItemListCustomer();
		for (MenuItem x : customerList) {

			System.out.println(x);
		}
	}

	private static void testModifyMenuItem() throws ParseException {

		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem menuItem = new MenuItem(4, "Chicken Biryani", 110.0f, false, DateUtil.convertToDate("17/08/2019"), "Hyd Special",
				false);
		menuItemDao.modifyMenuItem(menuItem);
	}
}
