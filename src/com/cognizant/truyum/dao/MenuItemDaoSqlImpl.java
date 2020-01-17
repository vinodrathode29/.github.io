package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoSqlImpl implements MenuItemDao {

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement preparedStatement = null;

		List<MenuItem> menuItemList = new ArrayList<MenuItem>();

		ResultSet resultSet;
		boolean active, freeDelivery;

		try {
			conn = ConnectionHandler.getConnection();

			String sql = ("select * from menu_item");
			if (conn != null) {
				preparedStatement = conn.prepareStatement(sql);

				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {

					int id = rs.getInt("me_id");
					String name = rs.getString("me_name");
					Date dateOfLaunch = rs.getDate("me_date_of_launch");
					String isActive = rs.getString("me_active");
					float price = rs.getFloat("me_price");

					String category = rs.getString("me_category");

					String isFreeDelivery = rs.getString("me_free_delivery");

					if (isFreeDelivery != null && isFreeDelivery.equalsIgnoreCase("Yes")) {
						freeDelivery = true;
					} else {
						freeDelivery = false;
					}
					if (isActive != null && isActive.equalsIgnoreCase("Yes")) {
						active = true;
					} else {
						active = false;
					}

					MenuItem menuItem = new MenuItem(id, name, price, active, dateOfLaunch, category, freeDelivery);
					
					System.out.println(menuItem);
					menuItemList.add(menuItem);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		List<MenuItem> menuItemList = new ArrayList<MenuItem>();
		ResultSet resultSet;
		boolean active, freeDelivery;
		try {
			conn = ConnectionHandler.getConnection();

			String sql = ("select * from menu_item "
					+ "where me_date_of_launch <= curdate()"
					+ " and me_active='Yes'");

			if (conn != null) {

				preparedStatement = conn.prepareStatement(sql);
				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {

					int id = rs.getInt(1);

					String name = rs.getString(2);

					Date dateOfLaunch = rs.getDate(5);

					String isActive = rs.getString(4);

					float price = rs.getFloat(3);

					String category = rs.getString(6);

					String isFreeDelivery = rs.getString(7);

					if (isFreeDelivery != null && isFreeDelivery.equalsIgnoreCase("Yes")) {
						freeDelivery = true;

					} else {
						freeDelivery = false;
					}

					if (isActive != null && isActive.equalsIgnoreCase("Yes")) {
						active = true;

					} else {
						active = false;
					}

					MenuItem menuItem = new MenuItem(id, name, price, active, dateOfLaunch, category, freeDelivery);

					System.out.println(menuItem);

					menuItemList.add(menuItem);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			try {

				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return menuItemList;

	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionHandler.getConnection();
		try {

		String sql = "update menu_item"
				+ "set me_name=?,"
				+ "me_price=?,"
				+ "me_active=?,"
				+ "me_date_of_launch=?,"
				+ "me_category=?,"
				+ "me_free_delivery=?"
				+ " where me_id=?";

	
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, menuItem.getName());

			ps.setFloat(2, menuItem.getPrice());

			if (menuItem.isActive()) {
				ps.setString(3, "Yes");
			} else {
				ps.setString(3, "No");
			}
			ps.setDate(4, new java.sql.Date(menuItem.getDateOfLaunch().getTime()));
			
			ps.setString(5, menuItem.getCategory());

			if (menuItem.isFreeDelivery()) {
				ps.setString(6, "Yes");

			} else {
				ps.setString(6, "No");
			}

			ps.setLong(7, menuItem.getId());

			ps.executeUpdate();

		} catch (SQLException sq) {
			sq.printStackTrace();

		} finally {
			try {
				conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public MenuItem getMenuItem(long MenuItemId) {

		Connection con = ConnectionHandler.getConnection();

		ResultSet rs;

		MenuItem menuItem = null;

		if (con != null) {

			try {

				String sql = "select * from menu_item where me_id=?";

				PreparedStatement ps = con.prepareStatement(sql);

				ps.setLong(1, MenuItemId);

				rs = ps.executeQuery();

				boolean active, freeDelivery;

				Date date_of_launch;

				if (rs.next()) {

					String name = rs.getString(2);

					float price = rs.getFloat(3);

					String isActive = rs.getString(4);

					date_of_launch = rs.getDate(5);

					String category = rs.getString(6);

					String isFreeDelivery = rs.getString(7);

					if (isActive != null && isActive.equalsIgnoreCase("Yes"))

						active = true;

					else

						active = false;

					if (isFreeDelivery != null && isFreeDelivery.equalsIgnoreCase("Yes"))

						freeDelivery = true;

					else

						freeDelivery = false;

					menuItem = new MenuItem(MenuItemId, name, price,active, date_of_launch, category,freeDelivery);

				}

			} catch (SQLException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			} finally {

				try {

					con.close();

				} catch (SQLException e) {

					// TODO Auto-generated catch block

					e.printStackTrace();

				}

			}

		}

		return menuItem;

	}

}
