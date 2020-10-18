package br.com.pw.gof.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.pw.gof.common.util.ResourceUtil;

public class JdbcConnection {
	
	protected static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName(ResourceUtil.getInstance().getProperty("jdbc.driver"));
			String url = ResourceUtil.getInstance().getProperty("jdbc.url");
			String user = ResourceUtil.getInstance().getProperty("jdbc.user");
			String password = ResourceUtil.getInstance().getProperty("jdbc.password");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	protected void closeConnection(ResultSet resultset, Statement statement, Connection connection) {
		try {
			if(resultset!=null) {
				resultset.close();
			}
			if(statement!=null) {
				statement.close();
			}
			if(connection!=null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
