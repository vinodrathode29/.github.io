package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao {

	@Override
	public void addCartItem(long userId, long menuItemId) {
		// TODO Auto-generated method stub

		Connection con = ConnectionHandler.getConnection();

			String sql = "insert into cart values(default,?,?)";
			
			try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setLong(1, userId);
			ps.setLong(2, menuItemId);
			
			ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			try {
				con.close();

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		// TODO Auto-generated method stub
		Connection con = ConnectionHandler.getConnection();
		List<MenuItem> menuItemList = new ArrayList<MenuItem>();

		PreparedStatement ps;

		ResultSet resultSet;

		boolean active, freeDelivery;

		MenuItem menuItem = null;

		try {

			Cart cart = new Cart();

			StringBuffer sqlBuffer = new StringBuffer();

			sqlBuffer.append("SELECT menu_item.me_id, "
							+ "menu_item.me_name ,"
							+ " menu_item.me_price ,"
							+ "menu_item.me_active,"
							+ "menu_Item.me_date_of_launch,"
							+ "menu_item.me_category, "
							+ "menu_item.me_free_delivery"
							+ " FROM menu_item ")

					.append("INNER JOIN cart ON menu_item.me_id = cart.ct_pr_id WHERE cart.ct_us_id = ?");

			ps = con.prepareStatement(sqlBuffer.toString());
			ps.setLong(1, userId);

			resultSet = ps.executeQuery();

			while (resultSet.next()) {

				int menuItemId = resultSet.getInt(1);
				String name = resultSet.getString(2);
				float price = resultSet.getFloat(3);
				String isActive = resultSet.getString(4);
				Date date_of_launch = resultSet.getDate(5);
				String category = resultSet.getString(6);
				String isFreeDelivery = resultSet.getString(7);
				
				if (isActive != null && isActive.equalsIgnoreCase("Yes"))
					active = true;
				
				else
					active = false;
				if (isFreeDelivery != null && isFreeDelivery.equalsIgnoreCase("Yes"))
					freeDelivery = true;
				
				else
					freeDelivery = false;

				menuItem = new MenuItem(menuItemId, name, price, active, date_of_launch, category, freeDelivery);

				menuItemList.add(menuItem);
			}

			cart.setMenuItemList(menuItemList);

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
		if (menuItemList.size() == 0) {

			throw new CartEmptyException("Cart is Empty");
		}
		return menuItemList;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		// TODO Auto-generated method stub
		Connection con = ConnectionHandler.getConnection();

		try {
			String sql = "delete from cart where ct_us_id=? and  ct_pr_id=? limit 1";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setLong(1, userId);
			ps.setLong(2, menuItemId);

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
