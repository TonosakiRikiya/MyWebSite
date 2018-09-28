package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import base.DBManager;
import beans.UserDatabeans;


public class UserDAO {

	public static void insertUser(UserDatabeans udb) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement("INSERT INTO t_user(name,login_id,address,login_password,create_date) VALUES(?,?,?,?,?)");
			ps.setString(1,udb.getName());
			ps.setString(2, udb.getLoginId());
			ps.setString(3, udb.getAddress());
			ps.setString(4, udb.getPassword());
			ps.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
			ps.executeUpdate();
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public UserDatabeans findByLoginInfo(String login_id,String password) {
		 Connection conn = null;
		 try {
			 conn =DBManager.getConnection();

			 String sql ="SELECT * FROM user WHERE login_id =? and password=?";

			 PreparedStatement pStmt= conn.prepareStatement(sql);
			 pStmt.setString(1,login_id);
			 pStmt.setString(2,password);

			 ResultSet rs=pStmt.executeQuery();
			 if(!rs.next()) {
				 return null;
			 }
			 String login_idDate= rs.getString("login_id");
			 String nameDate=rs.getString("name");
			 return new UserDatabeans();
		 }catch(SQLException e){
			 e.printStackTrace();
			 return null;
		 }finally {
			 if(conn!=null) {
				 try {
					 conn.close();
				 }catch(SQLException e){
					 e.printStackTrace();
					 return null;
				 }
			 }
		 }
	 }

	public static int getUserId(String loginId,String password) throws SQLException{
		Connection con =null;
		PreparedStatement ps = null;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement("SELECT * FROM t_user WHERE login_id=?");
			ps.setString(1, loginId);

			ResultSet rs =ps.executeQuery();

			int userId =0;
			while(rs.next()) {
				if(password.equals(rs.getString("login_password")));
				userId =rs.getInt("id");
				break;
			}
			return userId;
		} catch (SQLException e) {
		System.out.println(e.getMessage());
		throw new SQLException(e);
		}finally {
			if(con != null) {
				con.close();
			}
		}
	}

	public static UserDatabeans getUserDatabeansByUserId(int userId) throws SQLException{
		UserDatabeans udb = new UserDatabeans();
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con= DBManager.getConnection();
			ps= con.prepareStatement("SELECT id,name,login_id,address FROM t_user WHERE id=" + userId);
			ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					udb.setId(rs.getInt("id"));
					udb.setName(rs.getString("name"));
					udb.setLoginId(rs.getString("login_id"));
					udb.setAddress(rs.getString("address"));

				}
			ps.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		}finally {
			if(con != null) {
				con.close();
			}
		}
		return udb;
	}

	public static void updateUser(UserDatabeans udb) throws SQLException{
		UserDatabeans updateUdb = new UserDatabeans();
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement("UPDATE t_user SET name=?, login_id=?, address=? WHERE id=?");
			ps.setString(1, udb.getName());
			ps.setString(2, udb.getLoginId());
			ps.setString(3, udb.getAddress());
			ps.setInt(4, udb.getId());
			ps.executeUpdate();

			ps = con.prepareStatement("SELECT name, login_id,address FROM t_user WHERE id=" + udb.getId());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				updateUdb.setName(rs.getString("name"));
				updateUdb.setLoginId(rs.getString("login_id"));
				updateUdb.setAddress(rs.getString("address"));

			}
			ps.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		}finally {
			if(con != null) {
				con.close();
			}
		}
	}
	 public UserDatabeans Login(String login_id,String password) {
		 Connection conn = null;
		 try {
			 conn =DBManager.getConnection();

			 String sql ="SELECT * FROM user WHERE login_id =? and password=?";

			 PreparedStatement pStmt= conn.prepareStatement(sql);
			 pStmt.setString(1,login_id);
			 pStmt.setString(2, password);

			 ResultSet rs=pStmt.executeQuery();
			 if(!rs.next()) {
				 return null;
			 }
			 String login_idDate= rs.getString("login_id");
			 String nameDate=rs.getString("name");
			 return new UserDatabeans();
		 }catch(SQLException e){
			 e.printStackTrace();
			 return null;
		 }finally {
			 if(conn!=null) {
				 try {
					 conn.close();
				 }catch(SQLException e){
					 e.printStackTrace();
					 return null;
				 }
			 }
		 }
	 }

		public static boolean isOverlapLoginId(String loginId, int userId) throws SQLException {
			// 重複しているかどうか表す変数
			boolean isOverlap = false;
			Connection con = null;
			PreparedStatement st = null;

			try {
				con = DBManager.getConnection();
				// 入力されたlogin_idが存在するか調べる
				st = con.prepareStatement("SELECT login_id FROM t_user WHERE login_id = ? AND id != ?");
				st.setString(1, loginId);
				st.setInt(2, userId);
				ResultSet rs = st.executeQuery();

				System.out.println("searching loginId by inputLoginId has been completed");

				if (rs.next()) {
					isOverlap = true;
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				throw new SQLException(e);
			} finally {
				if (con != null) {
					con.close();
				}
			}

			System.out.println("overlap check has been completed");
			return isOverlap;
		}
}
