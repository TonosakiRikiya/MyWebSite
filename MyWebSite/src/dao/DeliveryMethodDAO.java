package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import base.DBManager;
import beans.DeliveryMethodDatabeans;

public class DeliveryMethodDAO {

	/**
	 * DBに登録されている配送方法を取得
	 * @return {DeliveryMethodDataBeans}
	 * @throws SQLException
	 */
	public static ArrayList<DeliveryMethodDatabeans> getAllDeliveryMethodDataBeans() throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement("SELECT * FROM m_delivery_method");

			ResultSet rs = st.executeQuery();

			ArrayList<DeliveryMethodDatabeans> deliveryMethodDatabeansList = new ArrayList<DeliveryMethodDatabeans>();
			while (rs.next()) {
				DeliveryMethodDatabeans dmdb = new DeliveryMethodDatabeans();
				dmdb.setId(rs.getInt("id"));
				dmdb.setName(rs.getString("name"));
				dmdb.setPrice(rs.getInt("price"));
				deliveryMethodDatabeansList.add(dmdb);
			}



			return deliveryMethodDatabeansList;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	/**
	 * 配送方法をIDをもとに取得
	 * @param DeliveryMethodId
	 * @return DeliveryMethodDataBeans
	 * @throws SQLException
	 */
	public static DeliveryMethodDatabeans getDeliveryMethodDatabeansByID(int DeliveryMethodId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement(
					"SELECT * FROM m_delivery_method WHERE id = ?");
			st.setInt(1, DeliveryMethodId);

			ResultSet rs = st.executeQuery();

			DeliveryMethodDatabeans dmdb = new DeliveryMethodDatabeans();
			if (rs.next()) {
				dmdb.setId(rs.getInt("id"));
				dmdb.setName(rs.getString("name"));
				dmdb.setPrice(rs.getInt("price"));
			}



			return dmdb;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	/**
     *購入IDによる配送方法検索
     * @param buyId
     * @return dmdb DeliveryMethodDataBeans
     *             配送方法の情報に対応するデータを持つJavaBeans
     * @throws SQLException
     */
	public static DeliveryMethodDatabeans getDeliveryMethodDatabeansByBuyId(int buyId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement(
					"SELECT m_delivery_method.name,"
					+ " m_delivery_method.price"
					+ " FROM t_buy"
					+ " JOIN m_delivery_method"
					+ " ON m_delivery_method.id = t_buy.delivery_method_id"
					+ " WHERE t_buy.id = ?");
			st.setInt(1, buyId);

			ResultSet rs = st.executeQuery();
			DeliveryMethodDatabeans dmdb = new DeliveryMethodDatabeans();

			while (rs.next()) {
				dmdb.setName(rs.getString("name"));
				dmdb.setPrice(rs.getInt("m_delivery_method.price"));

			}


			return dmdb;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}
}
