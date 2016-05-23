package com.nucsoft.bookstore.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.commons.dbutils.DbUtils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	// 由于数据源对象很大，所有设置为静态资源，使其只有一份
	private static DataSource dataSource = new ComboPooledDataSource("c3p0");

	/**
	 * 获取数据库连接
	 */
	public static Connection getConnection() {
		Connection connection = null;

		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}
	
	/**
	 * 释放资源
	 */
	public static void realseResources(Connection connection, Statement statement, ResultSet resultSet) {
		try {
			DbUtils.close(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			DbUtils.close(statement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			DbUtils.close(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
