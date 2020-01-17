package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {
	public static void main(String args[]) {
		System.out.println("===========Admin Menu List============");
		testGetMenuItemListAdmin();
		System.out.println("===========Customer Menu List============");
		testGetMenuItemListCustomer();
		testModifyMenuItem();
		System.out.println("===========Modified Menu List============");
	
		testGetMenuItemListAdmin();
		
	}
	public static void testGetMenuItemListAdmin() {
		MenuItemDaoSqlImpl menuItemDaoSqlImpl = new MenuItemDaoSqlImpl();
		
		List<MenuItem> menuItemList = menuItemDaoSqlImpl.getMenuItemListAdmin();
		for (MenuItem  x: menuItemList) {
		
		}
	}
	public static void testGetMenuItemListCustomer() {
		MenuItemDaoSqlImpl menuItemDaoSqlImpl = new MenuItemDaoSqlImpl();
		
		List<MenuItem> menuItemList = menuItemDaoSqlImpl.getMenuItemListCustomer();
		for (MenuItem menuItem : menuItemList) {
			
		}
}
	public static void testModifyMenuItem() {
		MenuItemDaoSqlImpl menuItemDao = new MenuItemDaoSqlImpl();
		
		try {
			MenuItem menuItem = new MenuItem(1, "Biryani Rice", 155.00f, true, DateUtil.convertToDate("02/02/2015"), "Main Course", true);
			
			menuItemDao.modifyMenuItem(menuItem);
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

