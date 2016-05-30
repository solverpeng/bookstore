package com.nucsoft.bookstore.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.nucsoft.bookstore.utils.JDBCUtils;

public abstract class BaseDao<T> {
	private QueryRunner queryRunner = new QueryRunner();
	private Class<T> beanType = null;

	@SuppressWarnings("unchecked")
	public BaseDao() {
		Type type = this.getClass().getGenericSuperclass();
		ParameterizedType tp = (ParameterizedType) type;
		beanType = (Class<T>) tp.getActualTypeArguments()[0];
	}

	/**
	 * 查询泛型对象列表
	 */
	public List<T> getBeanList(String sql, Object... params) {
		List<T> list = null;
		Connection connection = JDBCUtils.getConnection();
		BeanListHandler<T> beanListHandler = new BeanListHandler<T>(beanType);

		try {
			list = queryRunner.query(connection, sql, beanListHandler, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.realseResources(connection, null, null);
		}

		return list;
	}

	/**
	 * 查询单个泛型对象
	 */
	public T getBean(String sql, Object... params) {
		T t = null;
		Connection connection = JDBCUtils.getConnection();
		ResultSetHandler<T> handler = new BeanHandler<T>(beanType);

		try {
			t = queryRunner.query(connection, sql, handler, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.realseResources(connection, null, null);
		}
		return t;
	}

	/**
	 * 通用的增删改
	 */
	public void commonUpdate(String sql, Object... params) {
		Connection connection = JDBCUtils.getConnection();
		try {
			queryRunner.update(connection, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JDBCUtils.realseResources(connection, null, null);
	}
	
	@SuppressWarnings("unchecked")
	public <V> V getSingleValue(String sql, Object...params) {
		V v = null;
		Connection connection = JDBCUtils.getConnection();
		try {
			v = (V) queryRunner.query(connection, sql, new ScalarHandler(), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtils.realseResources(connection, null, null);
		return v;
	}

}
