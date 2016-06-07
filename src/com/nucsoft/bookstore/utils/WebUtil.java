package com.nucsoft.bookstore.utils;

import java.io.IOException;
import java.lang.reflect.Field;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtil {
	
	
	public static void sendData(HttpServletRequest req, HttpServletResponse resp, String attributeName,
			Object attributeValue, String url) throws ServletException, IOException {
		if (attributeName != null) {
			req.setAttribute(attributeName, attributeValue);
			req.getRequestDispatcher(url).forward(req, resp);
		} else {
			sendMessage(req, resp, "程序出错!");
		}
	}

	public static void sendMessage(HttpServletRequest req, HttpServletResponse resp, String message)
			throws ServletException, IOException {
		req.setAttribute("message", message);
		req.getRequestDispatcher("/result.jsp").forward(req, resp);
	}

	public static <T> T param2Bean(HttpServletRequest req, Class<T> beanType) {
		T t = null;

		try {
			t = beanType.newInstance();
			Field[] fields = beanType.getDeclaredFields();
			for (Field field : fields) {
				String name = field.getName();
				String value = req.getParameter(name);
				if (value != null) {
					BeanUtils.copyProperty(t, name, value);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return t;
	}
}
